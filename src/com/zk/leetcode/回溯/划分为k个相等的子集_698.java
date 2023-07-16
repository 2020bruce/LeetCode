package com.zk.leetcode.回溯;

import java.util.Arrays;

public class 划分为k个相等的子集_698 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 2};
        int k = 2;
        boolean b = canPartitionKSubsets(nums, k);
        System.out.println(b);

    }
    static boolean flag;
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        Integer[] iNums = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            iNums[i] = nums[i];
        }
        Arrays.sort(iNums, ((o1, o2) -> {return o2 - o1;}));
        if(sum % k != 0){
            return false;
        }
        int len = sum / k;

        int[] buckets = new int[k];
        backtrack(iNums, buckets, len,  0);
        return flag;
    }

    private static void backtrack(Integer[] nums, int[] buckets, int len, int index) {
        if(index == nums.length){
            flag = true;
            return;
        }
        for(int i = 0; i < buckets.length; i++){
            if(i > 0 && buckets[i] == buckets[i - 1]){
                continue;
            }
            if(nums[index] + buckets[i] > len){
                continue;
            }
            buckets[i] += nums[index];
            backtrack(nums, buckets, len, index + 1);
            buckets[i] -= nums[index];
            if(buckets[i] == 0){
                return;
            }
        }
    }
}













