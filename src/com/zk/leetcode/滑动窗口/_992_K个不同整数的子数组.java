package com.zk.leetcode.滑动窗口;

public class _992_K个不同整数的子数组 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        int subarrays = subarraysWithKDistinct(nums, k);
        System.out.println(subarrays);
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysNotMoreThanKDistinct(nums, k) - subarraysNotMoreThanKDistinct(nums, k - 1);
    }

    private static int subarraysNotMoreThanKDistinct(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int count = 0;
        int ans = 0;
        int[] freq = new int[n + 1];
        while(right < n){
            if(freq[nums[right]] == 0){
                count++;
            }
            freq[nums[right]]++;
            right++;
            while(count > k){
                freq[nums[left]]--;
                if(freq[nums[left]] == 0){
                    count--;
                }
                left++;
            }
            ans += right - left;
        }
        return ans;
    }
}



























