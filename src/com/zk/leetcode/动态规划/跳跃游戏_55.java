package com.zk.leetcode.动态规划;

public class 跳跃游戏_55 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        boolean b = canJump(arr);
        System.out.println(b);
    }
    public static boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(max[i - 1] >= i ) {
                max[i] = Math.max(max[i - 1], i + nums[i]);
                if(max[i] >= nums.length - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
