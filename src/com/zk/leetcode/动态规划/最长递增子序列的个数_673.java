package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 最长递增子序列的个数_673 {
    public static void main(String[] args) {
        int[] nums = {1,2,4,3,5,4,7,2};
        int numberOfLIS = findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] counts = new int[n];
        Arrays.fill(counts, 1);
        int res = 0;
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        counts[i] = counts[j];
                    }else if(dp[i] == dp[j] + 1){
                        counts[i] += counts[j];
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        for(int i = 0; i < n; i++){
            if(dp[i] == max){
                res += counts[i];
            }
        }


        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(counts));

        return res;
    }
}
