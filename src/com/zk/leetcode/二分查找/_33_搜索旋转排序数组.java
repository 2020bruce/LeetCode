package com.zk.leetcode.二分查找;

public class _33_搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        int i = search(nums, target);
        System.out.println(i);
    }

    public static int search(int[] nums, int target) {
        int n = nums.length;
        int k = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] < nums[i - 1]){
                k = i;
                break;
            }
        }

        int lRes = binarySearch(nums, target, 0, k - 1);
        int rRes = binarySearch(nums, target, k, n - 1);


        return lRes > rRes ? lRes : rRes;
    }

    private static int binarySearch(int[] nums, int target, int l, int r){
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
