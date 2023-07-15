package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _764_最大加号标志 {
    public static void main(String[] args) {
        int n = 5;
        int[][] mines = {{3, 0}, {3, 3}};
        int i = orderOfLargestPlusSign(n, mines);
        System.out.println(i);
    }
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] g = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) Arrays.fill(g[i], 1);
        for (int[] info : mines) g[info[0] + 1][info[1] + 1] = 0;
        int[][] a = new int[n + 2][n + 2], b = new int[n + 2][n + 2], c = new int[n + 2][n + 2], d = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (g[i][j] == 1) {
                    a[i][j] = a[i - 1][j] + 1;
                    b[i][j] = b[i][j - 1] + 1;
                }
                if (g[n + 1 - i][n + 1 - j] == 1) {
                    c[n + 1 - i][n + 1 - j] = c[n + 2 - i][n + 1 - j] + 1;
                    d[n + 1 - i][n + 1 - j] = d[n + 1 - i][n + 2 - j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, Math.min(Math.min(a[i][j], b[i][j]), Math.min(c[i][j], d[i][j])));
            }
        }
        return ans;

    }
}
