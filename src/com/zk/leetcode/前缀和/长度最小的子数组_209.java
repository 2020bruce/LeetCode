package com.zk.leetcode.前缀和;

import java.util.Arrays;

public class 长度最小的子数组_209 {
    public static void main(String[] args) {
        int target = 15;
        int[] nums = {1,2,3,4,5};
        int i = minSubArrayLenBest(target, nums);
        System.out.println(i);
    }

    //滑动窗口
    public static int minSubArrayLenBest(int target, int[] nums){
        int sum = 0, lo = 0, hi = 0, min = Integer.MAX_VALUE;
        int n = nums.length;
        while(hi < n){
            sum += nums[hi++];
            while(sum >= target){
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    //前缀和
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for(int i = 1; i <= n; i++){
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            if(sums[i] < target){
                continue;
            }
            int l = 0, r = i;
            while(l <= r){
                int mid = (l + r) / 2;
                if(sums[mid] <= sums[i] - target){
                    res = Math.min(res, i - mid);
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }

        }
        System.out.println(Arrays.toString(sums));
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
