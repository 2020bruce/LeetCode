package com.zk.leetcode.二分查找;

public class _704_二分查找 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = -2;
        int i = search(nums, target);
        System.out.println(i);

    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = -1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                res = mid;
                break;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return res;
    }
}




