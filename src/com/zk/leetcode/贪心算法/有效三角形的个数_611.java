package com.zk.leetcode.贪心算法;

import java.util.Arrays;

public class 有效三角形的个数_611 {
    public static void main(String[] args) {
        int[] nums = {4,2,3,4};
        int i = triangleNumber(nums);
        System.out.println(i);
    }

    //贪心
    public static int triangleNumberBest(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        if(n < 3){
            return 0;
        }
        int res = 0;
        for(int i = n - 1; i >= 2; i--){
            int l = 0, r = i - 1;
            while(l < r){
                if(nums[l] + nums[r] > nums[i]){
                    res += r - l;
                    r--;
                }else{
                    l++;
                }

            }
        }
        return res;

    }


    //排序+二分查找
    public static int triangleNumber(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return 0;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int sum = nums[i] + nums[j];
                int l = j + 1, r = n - 1;
                while(l <= r){
                    int mid = (l + r) / 2;
                    if(sum > nums[mid]){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
                res += l - 1 - j;
            }

        }
        return res;
    }
}











