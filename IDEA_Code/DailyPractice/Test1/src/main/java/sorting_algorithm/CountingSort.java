package sorting_algorithm;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        /*int[] a = {6, 5, 4, 7, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        countingSort(a);
        System.out.println(Arrays.toString(a));*/

        int[] b = {1,-8,5,2,7,-3,6,-9,-8,9};
        System.out.println(Arrays.toString(b));
        countingSortPlus(b);
        System.out.println(Arrays.toString(b));
    }

    public static void countingSort(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        int[] temp = new int[max + 1];
        for(int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }

        int index = 0;
        for(int i = 0; i < temp.length; i++) {
            while(temp[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void countingSortPlus(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
            if(min > arr[i]) {
                min = arr[i];
            }
        }

        int[] temp = new int[max - min + 1];
        for(int i = 0; i < arr.length; i++) {
            temp[arr[i] - min]++;
        }
        int index = 0;
        for(int i = 0; i < temp.length; i++) {
            while(temp[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }
}
