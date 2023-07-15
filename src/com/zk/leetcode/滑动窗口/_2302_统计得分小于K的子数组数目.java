package com.zk.leetcode.滑动窗口;

public class _2302_统计得分小于K的子数组数目 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 5;
        long subarrays = countSubarrays(nums, k);
        System.out.println(subarrays);
    }

    /**
     * l表示左边界，r表示有边界，sum表示l到r所有值的和，ans表示得分小于K的子数组数量。
     * 1.滑动窗口，r向右滑动；
     * 2.若sum * (r - l + 1) >= k, 则l向右滑动；
     * 3.ans += r - l + 1。
     *
     * @param nums
     * @param k
     * @return
     */
    public static long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int l = 0, r = 0;
        long sum = 0, ans = 0;
        while(r < n){
            sum += nums[r];
            while(l <= r && sum * (r - l + 1) >= k){
                sum -= nums[l];
                l++;
            }
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}



























