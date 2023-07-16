package com.zk.dynamic;

import java.util.Arrays;

public class _1289_MinimumFallingPathSumII {
    public static void main(String[] args) {
        int[][] grid = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int sum = minFallingPathSum(grid);
        System.out.println(sum);
    }
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n]; // dp[i][j]表示以第i行第j列结尾的最小值


        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[0][i] = grid[0][i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(j != k){
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}
