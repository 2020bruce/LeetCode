package com.zk.leetcode.数学;

public class _263_丑数 {
    public static void main(String[] args) {
        int n = 7;
        boolean ugly = isUgly(n);
        System.out.println(ugly);
    }
    public static boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }
        int[] arr = {2, 3, 5};
        for(int a : arr){
            while(n % a == 0){
                n /= a;
            }
        }
        return n == 1;

    }
}
