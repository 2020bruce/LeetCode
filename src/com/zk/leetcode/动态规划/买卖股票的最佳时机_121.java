package com.zk.leetcode.动态规划;

public class 买卖股票的最佳时机_121 {
    public static void main(String[] args) {
        int[] prices = {2,1,2,1,0,1,2};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        int low = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] > prices[low]){
                dp[i] = Math.max(dp[i-1], prices[i] - prices[low]);
            }else{
                low = i;
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }
}












