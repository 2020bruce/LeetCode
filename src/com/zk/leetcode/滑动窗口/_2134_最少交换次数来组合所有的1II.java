package com.zk.leetcode.滑动窗口;

import java.util.Arrays;

public class _2134_最少交换次数来组合所有的1II {
    public static void main(String[] args) {
        int[] nums = {1,1,0,0,1};
        int minSwaps = minSwaps(nums);
        System.out.println(minSwaps);
    }

    /**
     * 设总1的数量为total，滑动窗口里面1的数量为c，此时窗口的长度为w
     * 1.限制滑动窗口大小为total，最少交换次数即为total - c
     * 2.total - c即为0需要被替换为1的位置
     * @param nums
     * @return
     */
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int total = Arrays.stream(nums).filter(o->o == 1).sum();
        int ans = Integer.MAX_VALUE;
        int c = 0;
        for(int i = 0; i < total; i++){
            c += nums[i];
        }
        ans = Math.min(ans, total - c);
        for(int i = total; i < n + total; i++){
            c -= nums[i - total];
            c += nums[i % n];
            ans = Math.min(ans, total - c);
        }
        return ans;
    }
}






























