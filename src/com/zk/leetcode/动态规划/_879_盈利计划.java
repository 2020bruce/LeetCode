package com.zk.leetcode.动态规划;

public class _879_盈利计划 {
    public static void main(String[] args) {
        int n = 5, minProfit = 3;
        int[] group = {2}, profit = {2};
        int schemes = profitableSchemes(n, minProfit, group, profit);
        System.out.println(schemes);
    }
    public static int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];// dp[i][j]表示 最多i名员工 最小盈利j 有多少种计划
        int jobs = group.length;
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }
        int MOD = (int)1e9 + 7;
        for(int i = 1; i <= jobs; i++){
            int members = group[i - 1], earn = profit[i - 1];
            for(int j = n; j >= members; j--){
                for(int k = minProfit; k >= 0; k--){
                    dp[j][k] = (dp[j][k] + dp[j - members][Math.max(0, k - earn)]) % MOD;
                }
            }
        }
        return dp[n][minProfit];
    }
}



















