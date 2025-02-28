package sorting_algorithm;

import java.util.Arrays;

//选择排序
//最好O(n^2) 最坏O(n^2) 平均O(n^2) 空间O(1)  不稳定排序:取值相同的元素在排序之后,可能元素顺序发生改变
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        // 外层循环控制排序的轮数，需要进行 n - 1 轮
        for (int i = 0; i < n - 1; i++) {
            // 假设当前轮的最小元素的索引为 i
            int minIndex = i;
            // 内层循环用于在未排序部分中找到最小元素的索引
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    // 如果找到比当前最小元素更小的元素，则更新最小元素的索引
                    minIndex = j;
                }
            }
            // 如果最小元素的索引不是 i，则交换 arr[i] 和 arr[minIndex]
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
