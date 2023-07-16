package com.zk.leetcode.动态规划;

public class _983_最低票价 {
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20}, costs = {7,2,15};
        int tickets = mincostTickets(days, costs);
        System.out.println(tickets);
    }
    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        for(int i = 0; i < days.length; i++) {
            dp[i + 1] = costs[0] + dp[i];
            int j = i - 1;
            while(j >= 0 && days[i] - days[j] < 7) {
                j--;
            }
            int k = j;
            while(k >= 0 && days[i] - days[k] < 30) {
                k--;
            }
            dp[i + 1] = Math.min(dp[i + 1], Math.min(dp[j + 1] + costs[1], dp[k + 1] + costs[2]));
        }
        return dp[dp.length - 1];
    }
}
