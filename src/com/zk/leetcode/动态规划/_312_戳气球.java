package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _312_戳气球 {
    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        int i = maxCoins(nums);
        System.out.println(i);
    }
    public static int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        for(int i = 1; i <= nums.length; i++){
            arr[i] = nums[i - 1];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println();

        int[][] dp = new int[arr.length][arr.length];
        for(int i = 1; i < dp.length - 1; i++){
            dp[i][i] = arr[i - 1] * arr[i] * arr[i + 1];
        }

        for(int start = dp.length - 2; start > 0; start--){
            for(int end = start + 1; end < dp.length - 1; end++){
                int ans = 0;
                int p;
                for(int i = start; i <= end; i++){
                    p = arr[start - 1] * arr[end + 1] * arr[i] + dp[start][i - 1] + dp[i + 1][end];
                    ans = Math.max(ans, p);
                }
                dp[start][end] = ans;
            }
        }
        for(int[] t : dp){
            System.out.println(Arrays.toString(t));
        }
        return dp[1][dp.length - 2];
    }
}
















