package com.zk.leetcode.分治;

import java.util.Arrays;

public class _912_排序数组 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int[] array = sortArray(nums);
        System.out.println(Arrays.toString(array));
    }
    public static int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    private static void sort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    private static void merge(int[] nums, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int l = left, r = mid + 1;
        int index = 0;
        while(l <= mid && r <= right){
            if(nums[l] <= nums[r]){
                temp[index++] = nums[l++];
            }else{
                temp[index++] = nums[r++];
            }
        }
        while(l <= mid){
            temp[index++] = nums[l++];
        }
        while(r <= right){
            temp[index++] = nums[r++];
        }
        for(int i = 0; i < temp.length; i++){
            nums[i + left] = temp[i];
        }
    }

}




























