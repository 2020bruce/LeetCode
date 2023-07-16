package com.zk.leetcode.动态规划;

import java.util.Arrays;
public class 最大平均值和的分组_813 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(nums));
        int k = 4;
        double v = largestSumOfAverages(nums, k);
        System.out.println(v);
    }
    public static double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] preSum = new double[n + 1];
        //前缀和
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(preSum));
        //dp【n】【k】表示n个字符分为k个子数组的最大平均值和
        double[][] dp = new double[n + 1][k + 1];

        for(int i = 1; i <= n; i++){
            dp[i][1] = preSum[i] / i;
            for(int K = 2; K <= k && K <= i; K++){
                for(int j = 1; j < i; j++){
                    dp[i][K] = Math.max(dp[i][K], dp[j][K - 1] + (preSum[i] - preSum[j]) / (i - j));
                }

            }
        }
        for(double[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[n][k];
    }
}















