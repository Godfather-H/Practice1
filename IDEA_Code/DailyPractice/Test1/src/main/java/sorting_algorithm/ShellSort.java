package sorting_algorithm;

import java.util.Arrays;

//插入排序
//最好O(nlogn) 最坏O(n^2) 平均O(nlogn) 空间O(1) 不稳定排序:取值相同的元素在排序之后,可能元素顺序发生改变
public class ShellSort {

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void shellSort(int[] array) {
        for(int gap = array.length >> 1; gap > 0; gap = gap >> 1) {
            for(int i = gap; i < array.length; i++){
                int value = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > value){
                    array[j + gap] = array[j];
                    j -= gap;
                }
                if(j != i - gap){
                    array[j + gap] = value;
                }
            }
        }
    }
}
