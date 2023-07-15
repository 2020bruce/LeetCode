package com.zk.leetcode.滑动窗口;

import java.util.Arrays;

public class _1658_将x减到0的最小操作数 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1,1};
        int x = 5;
        int i = minOperations(nums, x);
        System.out.println(i);
    }
    public static int minOperations(int[] nums, int x) {
        int n= nums.length;
        int[] prefix = new int[n + 1];
        for(int i = 1; i <= n; i++){
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        System.out.println(Arrays.toString(prefix));
        int beginIndex = 0;
        int min = Integer.MAX_VALUE;
        for(int i = n - 1; i > 0; i--){
            if(prefix[n] - prefix[i] > x){
                beginIndex = i + 1;
                break;
            }
        }
        System.out.println(beginIndex);

        int r = 0;
        for(int l = beginIndex; l <= n; l++){
            while(r <= l){
                int sum = prefix[n] - prefix[l] + prefix[r];
                if(sum == x){
                    min = Math.min(min, n - l + r);
                    r++;
                }else if(sum < x){
                    r++;
                }else{
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;

    }
}




















