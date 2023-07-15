package com.zk.leetcode.动态规划;

public class _63_不同路径Ⅱ {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0},
        };
        int i = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(obstacleGrid[i - 1][j - 1] == 0){
                    if(i == 1 && j == 1){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
