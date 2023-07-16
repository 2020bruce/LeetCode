package com.zk.leetcode.动态规划;

public class 乘积最大子数组_152 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int i = maxProductBest(nums);
    System.out.println(i);
    }

    //若数组中为负数，则交换最大值最小值
    public static int maxProductBest(int[] nums){
        int res = nums[0], min = nums[0], max = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++){
            if(nums[i] < 0){
                int t = max;
                max = min;
                min = t;

            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            res = Math.max(max, res);
        }
        return res;
    }

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            int all = nums[i];
            int max = nums[i];
            for(int j = i - 1; j >= 0; j--){
                all *= nums[j];
                max = Math.max(all, max);
                dp[i] = Math.max(dp[i - 1], max);
            }
        }
        return dp[n - 1];
    }
}

















