package com.zk.leetcode.哈希表;

public class _12_整数转罗马数字 {
    public static void main(String[] args) {
        int num = 1994;
        String s = intToRoman(num);
        System.out.println(s);
    }
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                builder.append(symbols[i]);
                num -= values[i];
            }
            if(num == 0){
                break;
            }
        }

        return builder.toString();
    }
}




































































