package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _1000_合并石头的最低成本 {
    public static void main(String[] args) {
        int[] stones = {3,5,1,2,6};
        int K = 3;
        int i = mergeStones(stones, K);
        System.out.println(i);
    }
    public static int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if((n - k) % (k - 1) != 0){
            return -1;
        }
        int[][] dp = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i) sum[i] = sum[i - 1] + stones[i - 1];
        for(int len = k; len <= n; len++){
            for(int i = 1; i + len - 1 <= n; i++){
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int p = i; p < j; p += k - 1){
                    dp[i][j] = Math.min(dp[i][j], dp[i][p] + dp[p + 1][j]);
                }

                if((j - i) % (k - 1) == 0){
                    dp[i][j] += sum[j] - sum[i - 1];
                }
            }
        }

        for(int[] t : dp){
            System.out.println(Arrays.toString(t));
        }

        return dp[1][n];
    }
}
