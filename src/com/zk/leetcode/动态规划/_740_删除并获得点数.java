package com.zk.leetcode.动态规划;

public class _740_删除并获得点数 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        int i = deleteAndEarn(nums);
        System.out.println(i);
    }
    public static int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num : nums){
            if(num > max){
                max = num;
            }
        }
        int[] sum = new int[max + 1];
        for(int num : nums){
            sum[num] += num;
        }

        if(sum.length == 1){
            return sum[0];
        }else if(sum.length == 2){
            return Math.max(sum[0], sum[1]);
        }

        int[] dp = new int[max + 1];
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 1], sum[i] + dp[i - 2]);
        }

        return dp[dp.length - 1];
    }
}



















