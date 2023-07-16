package com.zk.slideWindow;

public class _2401_LongestNiceSubarray {
    public static void main(String[] args) {
        int[] nums = {1,3,8,48,10};
        int subarray = longestNiceSubarray(nums);
        System.out.println(subarray);
    }
    public static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int temp = 0;
        for(int l = 0, r = 0; r < n; r++){
            while((temp & nums[r]) > 0){
                temp  ^= nums[l++];
            }
            temp |= nums[r];
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

}






















