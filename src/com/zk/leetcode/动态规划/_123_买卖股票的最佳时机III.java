package com.zk.leetcode.动态规划;

public class _123_买卖股票的最佳时机III {
    public static void main(String[] args) {
        int[] prices = {1,2,3,5,1,2};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int buy0 = -prices[0], sell0 = 0;
        int buy1 = -prices[0], sell1 = 0;
        for(int i = 1; i < n; i++){
            buy0 = Math.max(buy0, -prices[i]);
            sell0 = Math.max(sell0, prices[i] + buy0);
            buy1 = Math.max(buy1, sell0 - prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
        }
        return sell1;
    }
}
