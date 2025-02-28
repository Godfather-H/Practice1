package com.itheima;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Test2 {
    public enum SeasonEnum {
        SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
        private int seq;
        SeasonEnum(int seq) {
            this.seq = seq;
        }
        public int getSeq() {
            return seq;
        }
    }

    private static Integer number;

    public static void main(String[] args) throws IOException {
        /*// 缩进 4 个空格
        // 原来双斜线后面有一个空格
        String say = "hello";
        // 运算符的左右必须有一个空格
        int flag = 0;
        // 关键词 if 与括号之间必须有一个空格，括号内的 f 与左括号，0 与右括号不需要空格
        if (flag == 0) {
            System.out.println(say);
        }
        // 左大括号前加空格且不换行；左大括号后换行
        if (flag == 1) {
            System.out.println("world");
            // 右大括号前换行，右大括号后有 else，不用换行
        } else {
            System.out.println("ok");
            // 在右大括号后直接结束，则必须换行
        }

        StringBuilder sb = new StringBuilder();
        sb.append("hello")
                .append(" world")
                .append(" ok");

        Integer a = 5;
        Integer b = 5;
        System.out.println(a.equals(b));*/

       /* BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        if(x.compareTo(y) == 0){
            System.out.println("相等");
        }

        System.out.println(result());*/

        String s = "a,b,c,,";
        String[] ele = s.split(",");
        for (String string : ele) {
            System.out.println(string);
        }
    }

    public static int result() {
        return number;
    }
}