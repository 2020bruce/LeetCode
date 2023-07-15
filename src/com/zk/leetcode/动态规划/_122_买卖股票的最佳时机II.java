package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _122_买卖股票的最佳时机II {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }
    static final int MIN = Integer.MIN_VALUE / 2;
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        Arrays.fill(dp, MIN);
        dp[0] = 0;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(prices[i] > prices[j]){
                    dp[i] = Math.max(dp[i], dp[j] + prices[i] - prices[j]);
                }
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}


































