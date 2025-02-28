package sorting_algorithm;

import java.util.ArrayList;

public class RadixSort {
    public static void main(String[] args) {}

    public static void radixSort(String[] arr, int length) {
        ArrayList<String>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = length - 1; i >= 0; i--) {
            for(String s : arr) {
                buckets[s.charAt(i) - '0'].add(s);
            }
            int k = 0;
            for(ArrayList<String> bucket: buckets){
                for(String s : bucket){
                    arr[k++] = s;
                }
                bucket.clear();
            }
            System.out.println(arr.length);
        }
    }
}
