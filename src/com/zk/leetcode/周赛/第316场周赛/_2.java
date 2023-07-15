package com.zk.leetcode.周赛.第316场周赛;

public class _2 {
    public static void main(String[] args) {
        int[] nums = {3,12,9,6};
        int k = 3;
        int i = subarrayGCD(nums, k);
        System.out.println(i);
    }
    public static int gcd(int a, int b){
        return a % b == 0 ? b : gcd(b, a % b);
    }
    public static int subarrayGCD(int[] nums, int k) {
        int n = nums.length, res = 0;
        for(int i = 0; i < n; ++i){
            int temp = nums[i];
            for(int j = i; j < n; ++j){
                temp = gcd(temp, nums[j]);
                if(temp == k)
                    ++res;
                else if(nums[j] % k != 0)//不能整除k，直接退出
                    break;
            }
        }
        return res;
    }
}








































