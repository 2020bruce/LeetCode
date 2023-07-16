package com.zk.leetcode.滑动窗口;

public class _1031_两个非重叠子数组的最大和 {
    public static void main(String[] args) {
        int[] A = {0,6,5,2,2,5,1,9,4};
        int L = 1, M = 2;
        int i = maxSumTwoNoOverlap(A, L, M);
        System.out.println(i);
    }
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        for(int i = 1; i < n; i++){
            nums[i] += nums[i - 1];
        }
        int res = nums[firstLen + secondLen - 1];
        int lMax = nums[firstLen - 1], rMax = nums[secondLen - 1];
        for(int i = firstLen + secondLen; i < n; i++){
            lMax = Math.max(lMax, nums[i - secondLen] - nums[i - firstLen - secondLen]);
            rMax = Math.max(rMax, nums[i - firstLen] - nums[i - firstLen - secondLen]);
            res = Math.max(res, Math.max(lMax + nums[i] - nums[i - secondLen], rMax + nums[i] - nums[i - firstLen]));
        }
        return res;
    }
}




















