package com.zk.leetcode.二分查找;

public class 搜索插入位置_35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int half = (l + r) / 2;
            if(target == nums[half]){
                return half;
            }else if(target > nums[half]){
                l = half + 1;
            }else{
                r = half - 1;
            }
        }

        return l;


    }
}
