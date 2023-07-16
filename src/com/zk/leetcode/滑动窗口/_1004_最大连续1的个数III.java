package com.zk.leetcode.滑动窗口;

public class _1004_最大连续1的个数III {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int K = 2;
        int longestOnes = longestOnes(nums, K);
        System.out.println(longestOnes);
    }
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, ans = 0;
        for(int r = 0; r < n; r++){
            if(k == 0 && nums[r] == 0){
                ans = Math.max(ans, r - l);
                while(nums[l] == 1){
                    l++;
                }
                l++;
                k++;
            }
            if(nums[r] == 0){
                k--;
            }
        }
        return ans;
    }
}
