package com.zk.leetcode.记忆化搜索;

import java.util.Arrays;

public class _329_矩阵中的最长递增路径 {
    public static void main(String[] args) {
        int[][] matrix = {
                {7,8,9},
                {9,7,6},
                {7,2,3}
        };
        int path = longestIncreasingPath(matrix);
        System.out.println(path);
    }

    static int[][] dp;
    static int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m][n];

        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        Arrays.stream(dp).forEach(o-> System.out.println(Arrays.toString(o)));
        return ans;
    }

    private static int dfs(int[][] matrix, int row, int column) {
        int m = matrix.length, n = matrix[0].length;

        if(dp[row][column] != 0){
            return dp[row][column];
        }
        dp[row][column]++;
        for(int[] direction : directions){
            int x = row + direction[0], y = column + direction[1];
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[row][column]){
                dp[row][column] = Math.max(dp[row][column], dfs(matrix, x, y) + 1);
            }
        }
        return dp[row][column];
    }
}
