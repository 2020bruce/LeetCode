package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _918_环形子数组的最大和 {
    public static void main(String[] args) {
        int[] nums = {-2};
        int i = maxSubarraySumCircular(nums);
        System.out.println(i);
    }
    public static int maxSubarraySumCircular(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int[] maxDP = new int[n + 1];
        int[] minDP = new int[n + 1];
        int max = Integer.MIN_VALUE, min = 0;
        for(int i = 1; i <= n; i++){
            maxDP[i] = Math.max(nums[i - 1], maxDP[i - 1] + nums[i - 1]);
            max = Math.max(max, maxDP[i]);
        }
        for(int i = 1; i < n; i++){
            minDP[i] = Math.min(nums[i - 1], minDP[i - 1] + nums[i - 1]);
            min = Math.min(min, minDP[i]);
        }
        return Math.max(max, sum - min);
    }
}
