package heap;

public class MaxHeap {

    int[] array;

    int size;

    public MaxHeap(int capacity) {
        this.array = new int[capacity];
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    public void heapify(){
        //找到最后非叶子结点size/2 - 1;
        for(int i = size / 2 - 1; i >= 0; i--){
            down(i);
        }
    }

    public void down(int parent){
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int max = parent;

        if(left < array.length && array[left] > array[max]){
            max = left;
        }
        if(right < array.length && array[right] > array[max]){
            max = right;
        }
        if(max != parent){
            swap(parent, max);
            down(max);
        }
    }

    public void swap(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int peek(){
        return array[0];
    }

    public int poll(){
        int temp = array[0];
        array[0] = array[--size];
        down(0);
        return temp;
    }

    public int poll(int index){
        int temp = array[index];
        array[index] = array[--size];
        down(index);
        return temp;
    }

    public void replace(int replaced){
        array[0] = replaced;
        down(0);
    }

    public boolean offer(int offered){
        if(size == array.length) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }

    public void up(int offered){
        int child = size - 1;
        while(child > 0){
            int parent = (child - 1) / 2;
            if(offered > array[parent]){
                array[child] = array[parent];
                child = parent;
            } else {
                break;
            }
        }
        array[child] = offered;
    }
}
