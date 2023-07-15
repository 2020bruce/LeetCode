package com.zk.leetcode.滑动窗口;

public class _1493_删掉一个元素以后全为1的最长子数组 {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,0,1,1,0,1};
        int i = longestSubarray(nums);
        System.out.println(i);
    }
    public static int longestSubarray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int l = 0;
        int res = 0;
        for(int r = 0; r < n; r++){
            if(nums[r] == 0){
                sum++;
            }
            while(sum > 1){
                if(nums[l] == 0){
                    sum--;
                }
                l++;
            }
            res = Math.max(res, r - l + 1 - sum);
        }
        return sum == 1 ? res : res - 1;
    }
}
