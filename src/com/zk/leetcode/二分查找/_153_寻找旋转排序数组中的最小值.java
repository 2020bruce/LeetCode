package com.zk.leetcode.二分查找;

public class _153_寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int min = findMin(nums);
        System.out.println(min);
    }
    public static int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[l] <= nums[r]){
                return nums[l];
            }else{
                if(nums[mid] >= nums[l]){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
        }
        return nums[r];
    }
}
