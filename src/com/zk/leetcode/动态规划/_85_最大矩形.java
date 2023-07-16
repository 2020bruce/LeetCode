package com.zk.leetcode.动态规划;

public class _85_最大矩形 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int maximalRectangle = maximalRectangle(matrix);
        System.out.println(maximalRectangle);
    }
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][][] dp = new int[m + 1][n + 1][2]; // 0表示左，1表示上。
        int area = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char c = matrix[i - 1][j - 1];
                if(c == '1'){
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                    int min = dp[i][j][0];
                    for(int k = i; k > 0; k--){
                        min = Math.min(dp[k][j][0], min);
                        area = Math.max(area, min * (i - k + 1));
                    }
                }
            }
        }
        return area;
    }
}
























