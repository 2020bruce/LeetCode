package com.zk.leetcode.动态规划;

public class 打家劫舍Ⅱ_213 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int rob = rob(nums);
        System.out.println(rob);
    }
    public static int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }else if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp1 = new int[n - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n - 1; i++){
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }

        int[] dp2 = new int[n + 1];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1], nums[2]);
        for(int i = 3; i < n; i++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
