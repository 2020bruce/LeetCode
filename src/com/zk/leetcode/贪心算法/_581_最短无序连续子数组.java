package com.zk.leetcode.贪心算法;

public class _581_最短无序连续子数组 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3};
        int i = findUnsortedSubarray(nums);
        System.out.println(i);
    }
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, right = -1;
        int min = Integer.MAX_VALUE, left = -1;
        for(int i = 0; i < n; i++){
            if(nums[i] >= max){
                max = nums[i];
            }else{
                right = i;
            }
            if(nums[n - 1 - i] <= min){
                min = nums[n - 1 - i];
            }else{
                left = n - 1 - i;
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
