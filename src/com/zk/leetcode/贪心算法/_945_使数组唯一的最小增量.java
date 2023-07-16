package com.zk.leetcode.贪心算法;

import java.util.Arrays;

public class _945_使数组唯一的最小增量 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,2,1,7};
        int i = minIncrementForUnique(nums);
        System.out.println(i);
    }
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                int temp = nums[i];
                nums[i] = nums[i - 1] + 1;
                res += nums[i] - temp;
            }
        }
        return res;
    }
}
