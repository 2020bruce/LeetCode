package com.zk.leetcode.二分查找;

import java.util.Arrays;

public class _34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res = searchRange(nums, target);
        System.out.println(Arrays.toString(res));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int temp = -1, left = -1, right = -1;
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                temp = mid;
                break;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(temp == -1){
            return res;
        }else{
            res = findLeftAndRight(nums, temp);
        }
        return res;
    }

    private static int[] findLeftAndRight(int[] nums, int temp) {
        int[] res = {temp, temp};
        int l = temp - 1, r = temp + 1;
        while(l >= 0 && nums[l] == nums[temp]){
            res[0] = l;
            l--;
        }
        while(r < nums.length && nums[r] == nums[temp]){
            res[1] = r;
            r++;
        }
        return res;
    }

}




























