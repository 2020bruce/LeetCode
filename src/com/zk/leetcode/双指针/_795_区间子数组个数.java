package com.zk.leetcode.双指针;

public class _795_区间子数组个数 {
    public static void main(String[] args) {
        int[] nums = {2,9,2,5,6};
        int left = 2, right = 8;
        int max = numSubarrayBoundedMax(nums, left, right);
        System.out.println(max);
    }
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int l = -1, r = -1;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] > right){
                l = i;
                r = -1;
            }
            if(nums[i] >= left && nums[i] <= right){
                r = i;
            }
            if(r != -1){
                ans += r - l;
            }
        }
        return ans;
    }
}
































