package com.zk.leetcode.动态规划;

public class _931_下降路径最小和 {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}}; //13
        int sum = minFallingPathSum(matrix);
        System.out.println(sum);
    }
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n + 1][n + 1];
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(j == n){
                    dp[i][j] = matrix[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }else if(j == 1){
                    dp[i][j] = matrix[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                }else{
                    dp[i][j] = matrix[i - 1][j - 1] + Math.min(dp[i - 1][j + 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }

            }
        }
        for (int i = 1; i <= n; i++) {
            if(res > dp[n][i]){
                res = dp[n][i];
            }
        }
        return res;
    }
}
