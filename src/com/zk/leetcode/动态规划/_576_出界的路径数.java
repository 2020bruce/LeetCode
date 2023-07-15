package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _576_出界的路径数 {
    public static void main(String[] args) {
        int m = 8, n = 50, maxMove = 23, startRow = 5, startColumn = 26;
        int paths = findPaths(m, n, maxMove, startRow, startColumn);
        System.out.println(paths);
    }
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][][] dp = new int[maxMove + 1][m][n];
        int[][] position = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int res = 0;
        for(int step = 1; step <= maxMove; step++){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    res = 0;
                    for(int[] p : position){
                        if(i + p[0] < 0 || i + p[0] > m - 1 || j + p[1] < 0 || j + p[1] > n - 1){
                            res++;
                        }else{
                            dp[step][i][j] = (dp[step][i][j] + dp[step - 1][i + p[0]][j + p[1]]) % MOD;
                        }
                    }
                    dp[step][i][j] += res;
                }
            }
        }
        for(int i = 0; i < maxMove + 1; i++){
            for(int j = 0; j < m; j++){
                System.out.println(Arrays.toString(dp[i][j]));
            }
            System.out.println();
        }
        return dp[maxMove][startRow][startColumn];
    }
}




















