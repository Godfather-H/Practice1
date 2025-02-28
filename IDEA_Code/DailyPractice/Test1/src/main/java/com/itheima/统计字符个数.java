package com.itheima;

import java.util.*;

public class 统计字符个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] words = str.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue().compareTo(a.getValue()));

        for(Map.Entry<String, Integer> entry: list){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
