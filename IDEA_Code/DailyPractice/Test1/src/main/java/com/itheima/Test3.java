package com.itheima;

import java.util.*;

/*class People <T> {
    T name;

    public void setPeople(T name) {
        System.out.println(T instanceof String);
        System.out.println(name);
        this.name = name;
    }
}*/


public class Test3 {
    public static void main(String[] args) {
        String s = intToRoman(3749);
        System.out.println(s);
    }

    public static String intToRoman(int num) {
        String[] keys = {"M", "D", "C", "L", "X", "V", "I"};
        int[] values = {1000, 500, 100, 50, 10, 10, 5, 1};
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < keys.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(keys[i]);
            }
            if (num == 0) {
                return sb.toString();
            }
        }
        return "";
    }

    public static void test(int[] a) {
        int[] b = {1,2,3,4,5,6,7,8,9};
        a = b;
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void findFather(ArrayList<Integer> list, int aim){
        if(aim == 1){
            list.add(1);
            return;
        }

        list.add(aim);
        int n = (int) (Math.log(aim * 2 + 1) / Math.log(3));
        int start = (int) ((Math.pow(3, n) - 1) / 2);
        int location = (int) Math.ceil((aim - start) / 3);
        int father = (int) ((Math.pow(3, n - 1) - 1) / 2) + location;
        findFather(list, father);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(right < left){
            int nums = numbers[right] + numbers[left];
            if(nums > target){
                right--;
            } else if(nums < target){
                left++;
            } else {
                int[] ans = {left + 1, right + 1};
                return ans;
            }
        }
        int[] ans = {left + 1, right + 1};
        return ans;
    }
}
