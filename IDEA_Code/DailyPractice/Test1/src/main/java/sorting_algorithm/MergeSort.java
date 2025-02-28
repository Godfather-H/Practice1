package sorting_algorithm;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 7, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        split(arr, 0, arr.length - 1, temp);
    }

    public static void merge(int[] array, int i, int iEnd, int j, int jEnd, int[] temp){
        int len = jEnd - i + 1;
        int start = i;


        int k = 0;
        while(i <= iEnd && j <= jEnd) {
            if (array[i] < array[j]){
                temp[k] = array[i++];
            } else {
                temp[k] = array[j++];
            }
            k++;
        }

        while(i <= iEnd){
            temp[k++] = array[i++];
        }
        while(j <= jEnd){
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, start, len);
    }

    public static void split(int[] array, int left, int right, int[] temp){
        if(left == right) return;
        int mid = (left + right) >>> 1;
        split(array, left, mid, temp);
        split(array, mid + 1, right, temp);
        merge(array, left, mid, mid + 1, right, temp);
    }

    public static void insertSort(int[] array, int left, int right){
        
    }
}
