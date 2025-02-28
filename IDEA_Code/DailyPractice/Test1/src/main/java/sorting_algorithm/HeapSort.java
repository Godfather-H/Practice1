package sorting_algorithm;

import java.util.Arrays;

//堆排序
//最好O(nlogn) 最坏O(nlogn) 平均O(nlogn) 空间O(1)  不稳定排序:取值相同的元素在排序之后,可能元素顺序发生改变
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println("原数组:" + Arrays.toString(a));
        heapSort(a);
        System.out.println("堆排序:" + Arrays.toString(a));
    }

    public static void heapSort(int[] arr) {
        heapify(arr, arr.length - 1);
        for (int right = arr.length - 1; right > 0; right--) {
            swap(arr, 0, right);
            down(arr, 0, right);
        }
    }

    //建堆 O(n)
    private static void heapify(int[] arr, int size) {
        for(int i = size / 2 - 1; i >= 0; i--) {
            down(arr, i, size);
        }
    }

    /*private static void down(int[] array, int parent, int size) {
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        int max = parent;
        if (leftChild < size && array[leftChild] > array[max]) {
            max = leftChild;
        }
        if (rightChild < size && array[rightChild] > array[max]) {
            max = rightChild;
        }
        if (max != parent) {
            swap(array, parent, max);
            down(array, max, size);
        }
    }*/
    private static void down(int[] array, int parent, int size) {

        while (true){
            int leftChild = parent * 2 + 1;
            int rightChild = parent * 2 + 2;
            int max = parent;
            if (leftChild < size && array[leftChild] > array[max]) {
                max = leftChild;
            }
            if (rightChild < size && array[rightChild] > array[max]) {
                max = rightChild;
            }

            if (max == parent){
                break;
            }
            swap(array, parent, max);
            parent = max;
        }
    }


    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
