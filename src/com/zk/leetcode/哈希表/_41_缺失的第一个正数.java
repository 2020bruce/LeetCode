package com.zk.leetcode.哈希表;

import java.util.Arrays;

public class _41_缺失的第一个正数 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0 || nums[i] >= n + 1){
                nums[i] = n + 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n; i++){
            int t = Math.abs(nums[i]);
            if(t > 0 && t < n + 1){
                nums[t - 1] = -Math.abs(nums[t - 1]);
            }
        }

        for(int i = 0 ; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}
