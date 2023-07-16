package com.zk.leetcode.滑动窗口;

import java.util.Arrays;

public class _1838_最高频元素的频数 {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        int k = 5;
        int maxFrequency = maxFrequency(nums, k);
        System.out.println(maxFrequency);
    }
    public static int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        long total = 0;
        int ans = 1;
        int l = 0;
        for(int r = 1; r < n; r++){
            total += (long)(nums[r] - nums[r - 1]) * (r - l);
            while(total > k){
                total -= (nums[r] - nums[l]);
                ++l;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}








































