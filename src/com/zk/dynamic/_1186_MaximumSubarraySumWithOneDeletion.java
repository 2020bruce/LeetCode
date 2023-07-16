package com.zk.dynamic;

import java.util.Arrays;

public class _1186_MaximumSubarraySumWithOneDeletion {
    public static void main(String[] args) {
        int[] arr = {8,-1,6,-7,-4,5,-4,7,-6}; //17
        int maximumSum = maximumSum(arr);
        System.out.println(maximumSum);
    }

    /**
     * 定义int[][] dp， dp[i][j]表示前i - 1个数，j等于1已经删除了1个元素，0表示还未删除元素 的最大值。
     * @param arr
     * @return
     */
    public static int maximumSum(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        int ans = arr[0];
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], 0) + arr[i];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}

















