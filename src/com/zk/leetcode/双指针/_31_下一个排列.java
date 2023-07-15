package com.zk.leetcode.双指针;

import java.util.Arrays;

public class _31_下一个排列 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j > i; j--){
                if(nums[j] > nums[i]){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    Arrays.sort(nums, i + 1, n);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}
