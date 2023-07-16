package com.zk.leetcode.二分查找;

public class _162_寻找峰值 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        int peakElement = findPeakElement(nums);
        System.out.println(peakElement);
    }
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(nums[mid] > nums[mid + 1]){
                r = mid;
            }else{
                l = mid + 1;
            }

        }
        return l;
    }
}
