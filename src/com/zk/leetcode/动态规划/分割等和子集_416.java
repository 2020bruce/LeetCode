package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 分割等和子集_416 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1};
        boolean b = canPartitionBest(nums);
        System.out.println(b);

    }

    public static boolean canPartitionBest(int[] nums){
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[sum];
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int target = 0;
        for(int num : nums){
            target += num;
        }
        if(target % 2 == 1){
            return false;
        }
        target = target / 2;

        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for(int i = 0; i < n; i++){
            for(int j = 1; j <= target; j++){
                if(i > 0 && dp[i - 1][j]){
                    dp[i][j] = true;
                    continue;
                }
                if(j == nums[i]){
                    dp[i][j] = true;
                }else if(j > nums[i]){
                    if(i > 0){
                        dp[i][j] = dp[i - 1][j - nums[i]];
                    }

                }else{
                    if(i > 0){
                        dp[i][j] = dp[i - 1][j];
                    }else{
                        dp[i][j] = false;
                    }
                }

            }
        }
        for(boolean[] b : dp){
            System.out.println(Arrays.toString(b));
        }

        return dp[n - 1][target];
    }
}
