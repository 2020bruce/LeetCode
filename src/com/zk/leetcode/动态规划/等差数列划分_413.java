package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 等差数列划分_413 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 9, 10};
        int i = numberOfArithmeticSlices(nums);
        System.out.println(i);
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return 0;
        }
        int[] dp = new int[n + 1];
        int d = nums[1] - nums[0];
        int count = 2;
        for(int i = 3; i <= n; i++){
            if(d == nums[i - 1] - nums[i - 2]){
                count++;
                dp[i] = dp[i - 1] + count - 2;
            }else{
                d = nums[i - 1] - nums[i - 2];
                dp[i] = dp[i - 1];
                count = 2;
            }


        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}











