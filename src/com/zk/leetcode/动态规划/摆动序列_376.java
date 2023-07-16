package com.zk.leetcode.动态规划;

public class 摆动序列_376 {
    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        int i = wiggleMaxLengthBest(nums);
        System.out.println(i);
    }

    public static int wiggleMaxLengthBest(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int s1 = 1, s2 = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                s1 = s2 + 1;
            }else if(nums[i] < nums[i - 1]){
                s2 = s1 + 1;
            }
        }
        return Math.max(s1, s2);
    }

    //自己写的方法，代码冗长
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int n = nums.length;
        int sum1 = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1] && sum1 % 2 ==1){
                sum1++;
            }else if(nums[i] < nums[i - 1] && sum1 % 2 == 0){
                sum1++;
            }
        }
        int sum2 = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1] && sum2 % 2 ==0){
                sum2++;
            }else if(nums[i] < nums[i - 1] && sum2 % 2 == 1){
                sum2++;
            }
        }
        return sum1 > sum2 ? sum1 : sum2;

    }
}
