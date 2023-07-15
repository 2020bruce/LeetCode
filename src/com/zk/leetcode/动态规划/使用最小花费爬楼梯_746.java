package com.zk.leetcode.动态规划;

public class 使用最小花费爬楼梯_746 {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int i = minCostClimbingStairs(cost);
        System.out.println(i);
    }
    //dp[i]代表经过下标i到达楼梯顶部的最小代价
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[1] = cost[0];
        for(int i = 2; i <= n; i++){
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i - 1];
        }
        return Math.min(dp[n], dp[n - 1]);
    }
}










