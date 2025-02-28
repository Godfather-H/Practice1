package sorting_algorithm;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 7, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /*public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int value = arr[left];
        int l = left;
        int r = right + 1;
        while (true) {
            while (arr[++l] < value) {
                if (l == right) break;
            }
            while (arr[--r] > value) {
                if (r == left) break;
            }
            if (l >= r) break;
            swap(arr, l, r);
        }
        swap(arr, left, r);
        return r;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }*/

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int p = partition(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int l = left;
        int r = right + 1;
        while (true) {
            while (arr[++l] < pivot) {
                if (l == right) break;
            }
            while (arr[--r] > pivot) {
                if (l == right) break;
            }
            if (l >= r) {
                break;
            }
            swap(arr, l, r);
        }
        swap(arr, left, r);
        return r;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
