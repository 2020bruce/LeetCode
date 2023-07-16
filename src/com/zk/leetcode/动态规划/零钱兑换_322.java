package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 零钱兑换_322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int i = coinChange(coins, amount);
        System.out.println(i);
    }
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j : coins){
                if(i >= j && dp[i - j] != -1){
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
            if(dp[i] == Integer.MAX_VALUE){
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
}
