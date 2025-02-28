package sorting_algorithm;

import java.util.Arrays;

//冒泡排序
//最好O(n) 最坏O(n^2) 平均O(n^2) 空间O(1) 稳定排序:取值相同的元素在排序之后,元素顺序不发生改变
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        bubbleSortBest(a);
        System.out.println(Arrays.toString(a));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 外层循环控制排序的轮数，一共需要进行 n - 1 轮
        for (int i = 0; i < n - 1; i++) {
            // 内层循环用于比较相邻元素并交换位置
            for (int j = 0; j < n - i - 1; j++) {
                // 如果当前元素比下一个元素大，则交换它们的位置
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortBest(int[] arr) {
        int len = arr.length;
        int endIndex = len - 1;
        while (true) {
            int cur = -1;
            for (int i = 0; i < endIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    cur = i;
                }
            }

            if (cur == -1) {
                break;
            }
            endIndex = cur;
        }
    }
}
