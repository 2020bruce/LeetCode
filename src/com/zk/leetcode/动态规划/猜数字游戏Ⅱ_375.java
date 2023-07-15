package com.zk.leetcode.动态规划;

public class 猜数字游戏Ⅱ_375 {
    public static void main(String[] args) {
        int n = 10;
        int moneyAmount = getMoneyAmount(n);
        System.out.println(moneyAmount);
    }
    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1; i >= 1; i--){
            for(int j = i + 1; j <= n; j++){
                dp[i][j] = dp[i][j - 1] + j;
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }

            }
        }


        return dp[1][n];
    }
}
