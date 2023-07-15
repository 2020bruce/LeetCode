package com.zk.leetcode.周赛.第315场周赛;

public class _6207_统计定界子数组的数目 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,7,5};
        int minK = 1, maxK = 5;
        long l = countSubarrays(nums, minK, maxK);
        System.out.println(l);
    }
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long ans = 0L;
        int minI = -1, maxI = -1, i0 = -1;
        for(int i = 0; i < n; i++){
            if(minK == nums[i]){
                minI = i;
            }
            if(maxK == nums[i]){
                maxI = i;
            }
            if(nums[i] < minK || nums[i] > maxK){
                i0 = i;
            }
            ans += Math.max(Math.min(minI, maxI) - i0, 0);
        }
        return ans;
    }


}
