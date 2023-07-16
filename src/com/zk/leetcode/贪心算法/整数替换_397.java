package com.zk.leetcode.贪心算法;

public class 整数替换_397 {
    public static void main(String[] args) {
        int n = 10000;
        int i = integerReplacement(n);
        System.out.println(i);
    }
    public static int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }
        if(n % 2 == 0){
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));

    }
}
