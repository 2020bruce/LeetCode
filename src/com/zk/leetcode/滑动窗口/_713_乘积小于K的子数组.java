package com.zk.leetcode.滑动窗口;

public class _713_乘积小于K的子数组 {

    public static void main(String[] args) {
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;
        int i = numSubarrayProductLessThanK(nums, k);
        System.out.println(i);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int prod = 1, lo = 0;
        for(int hi = 0; hi < n; hi++){
            prod *= nums[hi];
            while(hi >= lo && prod >= k){
                prod /= nums[lo];
                lo++;
            }
            res += hi - lo + 1;
        }
        return res;
    }

}
































































