package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _396_旋转函数 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,6};
        int maxRotateFunction = maxRotateFunction(nums);
        System.out.println(maxRotateFunction);
    }
    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int cur = 0;
        int sum = Arrays.stream(nums).sum();
        for(int i = 0; i < n; i++){
            cur += i * nums[i];
        }
        ans = cur;
        for(int i = 1; i < n; i++){
            cur = cur + sum - n * nums[n - i];
            ans = Math.max(ans, cur);

        }
        return ans;
    }
}




























































