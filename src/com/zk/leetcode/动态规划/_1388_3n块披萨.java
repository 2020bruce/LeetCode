package com.zk.leetcode.动态规划;

public class _1388_3n块披萨 {
    public static void main(String[] args) {
        int[] slices = {2,4,3,1,10,6,1,2,10,2,8,9,4,8,8,8,10,3,9,10,7,9,4,5,4,3,1,10,6,1};
        int maxSizeSlices = maxSizeSlices(slices);
        System.out.println(maxSizeSlices);
    }
    public static int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int[] slices1 = new int[n - 1];
        System.arraycopy(slices, 1, slices1, 0, n - 1);
        int[] slices2 = new int[n - 1];
        System.arraycopy(slices, 0, slices2, 0, n - 1);

        return Math.max(calculate(slices1), calculate(slices2));
    }

    private static int calculate(int[] slices) {
        int n = slices.length;
        int choose = (n + 1) / 3;
        int[][] dp= new int[n + 1][choose + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= choose; j++){
                dp[i][j] = Math.max(dp[i - 1][j], (i >= 2 ? dp[i - 2][j - 1] : 0) + slices[i - 1]);
            }
        }

        return dp[n][choose];

    }
}
