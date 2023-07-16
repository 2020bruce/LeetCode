package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 整数拆分_343 {
    public static void main(String[] args) {
        int n = 10;
        int i = integerBreakDP(n);
        System.out.println(i);
    }


    //动态规划方法
    public static int integerBreakDP(int n){
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.max(Math.max(dp[i], j * dp[i - j]), j * (i - j));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }


    //数学方法，要么拆分成3，要么拆分成2
    public static int integerBreak(int n) {
        if(n == 2){
            return 1;
        }else if(n == 3){
            return 2;
        }
        int sum = 1;
        while(true){
            if(n == 0){
                break;
            }
            if(n == 4){
                sum *= 4;
                break;
            }
            if(n == 2){
                sum *=2;
                break;
            }

            n = n - 3;
            sum *=3;
        }
        return sum;
    }
}
