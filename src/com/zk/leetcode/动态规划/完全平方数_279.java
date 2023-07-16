package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 完全平方数_279 {
    public static void main(String[] args) {
        int i = numSquares(43);
        System.out.println(i);
    }
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int minn = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];

    }
}
