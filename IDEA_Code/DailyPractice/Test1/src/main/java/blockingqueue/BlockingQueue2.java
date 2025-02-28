package blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue2<E> implements BlockingQueue<E> {
    private int head;

    private int tail;

    private final AtomicInteger size;

    private final E[] array;

    private ReentrantLock headLock = new ReentrantLock();
    Condition headWaits = headLock.newCondition();

    private ReentrantLock tailLock = new ReentrantLock();
    Condition tailWaits = tailLock.newCondition();

    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
        size = new AtomicInteger(0);
    }

    public boolean isEmpty(){
        return size.get() == 0;
    }

    public boolean isFull(){
        return size.get() == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        tailLock.lockInterruptibly();
        int c;
        try {
            while (isFull()) {
                tailWaits.await();
            }
            array[tail++] = e;
            if (tail == array.length) {
                tail = 0;
            }
            c = size.getAndIncrement();
            if (c < array.length - 1) {
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }

        while (c == 0) {
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public boolean offer(E e, long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public E poll() throws InterruptedException {
        int s;
        E e;
        headLock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            e = array[head];
            array[head++] = null;
            if (head == array.length) {
                head = 0;
            }

            s = size.getAndDecrement();
            if (s > 1) {
                headWaits.signal();
            }
        } finally {
            headLock.unlock();
        }

        while (s == array.length) {
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
        return e;
    }
}
