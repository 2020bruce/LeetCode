package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _410_分割数组的最大值 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int m = 2;
        int splitArray = splitArray(nums, m);
        System.out.println(splitArray);
    }
    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        System.out.println(Arrays.toString(prefixSum));
        int[][] dp = new int[n][k + 1];


        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1] = prefixSum[i];
        }

        for(int i = 0; i < n; i++){
            for(int j = 2; j <= k; j++){
                for(int m = i; m >= 0; m--){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[m][j - 1],prefixSum[i] - prefixSum[m]));
                }
            }
        }

        return dp[n - 1][k];
    }
}



























