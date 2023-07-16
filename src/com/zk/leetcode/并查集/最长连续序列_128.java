package com.zk.leetcode.并查集;

import java.util.Arrays;

public class 最长连续序列_128 {
    public static void main(String[] args) {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i - 1] == 1){
                dp[i] = dp[i - 1] + 1;
            }else if(nums[i] == nums[i - 1]){
                dp[i] = dp[i - 1];
            }else{
                dp[i] = 1;
            }
            if(dp[i] > res){
                res = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
