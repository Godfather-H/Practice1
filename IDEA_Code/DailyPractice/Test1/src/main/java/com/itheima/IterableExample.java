package com.itheima;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MyIterableArray implements Iterable<Integer> {
    private final int[] array;

    public MyIterableArray(int[] array) {
        this.array = array;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < array.length;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        };
    }
}

public class IterableExample {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        MyIterableArray myArray = new MyIterableArray(array);

        for(int num: myArray) {
            System.out.println(num);
        }

        Iterator<Integer> iterator = myArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
