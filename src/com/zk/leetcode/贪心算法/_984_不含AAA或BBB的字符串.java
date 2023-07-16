package com.zk.leetcode.贪心算法;

public class _984_不含AAA或BBB的字符串 {
    public static void main(String[] args) {
        int a = 27, b = 33;
        String s = strWithout3a3b(a, b);
        System.out.println(s);
    }
    public static String strWithout3a3b(int a, int b) {
        StringBuilder builder = new StringBuilder();
        while(a > 0 && b > 0){
            if(a == b){
                builder.append("ab");
                a--;b--;
            }else if (a > b){
                builder.append("aab");
                a--;a--;
                b--;
            }else{
                builder.append("bba");
                b--;b--;
                a--;
            }
        }
        while(a > 0){
            builder.append("a");
            a--;
        }
        while(b > 0){
            builder.append("b");
            b--;
        }
        return builder.toString();
    }

}
