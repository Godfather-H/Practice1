package sorting_algorithm;

import java.util.Arrays;

public class MergeSortBottomUp {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 7, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSortBottomUp(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        for(int width = 1; width < len; width *= 2) {
            for(int left = 0; left < len; left += 2*width) {
                int right = Math.min(left + 2 * width - 1, len - 1);
                int mid = Math.min(left + width - 1, right);
                merge(arr, left, mid, mid + 1 , right, temp);
            }
        }
    }

    public static void merge(int[] arr, int i, int iEnd, int j, int jEnd, int[] temp){
        int start = i;
        int len = jEnd - start + 1;
        int k = 0;

        while(i <= iEnd && j <= jEnd){
            if(arr[i] < arr[j]){
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= iEnd){
            temp[k++] = arr[i++];
        }
        while(j <= jEnd){
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, start, len);
    }

//------------------------------------------------------------------------------------------------
    //算法课本中实现

    private static int[] aux;

    public static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
