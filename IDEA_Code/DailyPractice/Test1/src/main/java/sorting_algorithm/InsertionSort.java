package sorting_algorithm;

import java.util.Arrays;

//插入排序
//最好O(n) 最坏O(n^2) 平均O(n^2) 空间O(1) 稳定排序:取值相同的元素在排序之后,元素顺序不发生改变
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        // 从数组的第二个元素开始，因为第一个元素默认已排好序
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i - 1;
            // 将当前元素与已排序部分的元素从后往前比较
            while (j >= 0 && arr[j] > current) {
                // 如果已排序元素大于当前元素，将其往后移一位
                arr[j + 1] = arr[j];
                j--;
            }
            // 找到合适的位置插入当前元素
            if(j != i - 1){
                arr[j + 1] = current;
            }
        }
    }
}
