package com.itheima;

public class Z字形变换 {
    public static void main(String[] args) {}

    /*public String convert(String s, int numRows) {
        //计算有多少行，多少列
        int model = 2*numRows - 2;
        int n = s.length();
        int ans = n/model;
        int mod = n%model;
        int column = 2*ans;
        int mid = n - 1;
        if(mod == 0){
        } else if(mod > 0 && mod <= numRows){
            column += 1;
        } else {
            column += 2;
        }
        //初始化数组
        char[][] arr = new char[numRows][column];
        int index = 0;
        //填充数组
        for(int i = 0; i <= column; i++){ //i为列

        }
        return null;
    }*/
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()){
            return s;
        }

        //初始化每一行的stringbuilder
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        //填充sbs
        boolean goDown = true;
        int currentRow = 0;
        for (char c: s.toCharArray()){
            sbs[currentRow].append(c);
            //判断下一步是上升还是下降
            if(currentRow == 0){
                goDown = true;
            } else if(currentRow == numRows - 1){
                goDown = false;
            }

            //currentRow = goDown ? currentRow + 1 : currentRow - 1;
            currentRow += goDown ? 1 : -1;
        }

        //拼接答案
        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : sbs) {
            ans.append(sb.toString());
        }
        return ans.toString();
    }
}
