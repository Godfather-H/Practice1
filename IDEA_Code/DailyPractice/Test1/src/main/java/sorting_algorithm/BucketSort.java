package sorting_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] a = {60, 52, 43, 73, 32, 46, 21, 26, 89};
        System.out.println(Arrays.toString(a));
        bucketSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bucketSort(int[] arr) {
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        for(int ele : arr) {
            int bucket = ele / 10;
            addSequentially(buckets.get(bucket), ele);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for(int ele : bucket) {
                arr[index++] = ele;
            }
        }
    }

    public static void addSequentially(List<Integer> bucket, int ele) {
        int i = 0;
        while(i < bucket.size()) {
            if(bucket.get(i) >= ele) {
                break;
            }
            i++;
        }
        for(int j = i; j < bucket.size(); j++) {
            int temp = bucket.get(j);
            bucket.set(j, ele);
            ele = temp;
        }
        bucket.add(ele);
    }
}
