package com.zk.leetcode.动态规划;

public class 最大正方形_221 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        char[][] m = {
                {'0', '1'},
                {'1', '0'}
        };
        int i = maximalSquare(m);
        System.out.println(i);
    }
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    if(matrix[i][j] == '0'){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1;
                        if(result < dp[i][j]){
                            result = dp[i][j];
                        }
                    }
                }else{
                    if(matrix[i][j] == '0'){
                        dp[i][j] = 0;
                    }else {
                        //关键代码
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        if(result < dp[i][j]){
                            result = dp[i][j];
                        }

                    }
                }
            }
        }
        result = result * result;
        return result;
    }

}















