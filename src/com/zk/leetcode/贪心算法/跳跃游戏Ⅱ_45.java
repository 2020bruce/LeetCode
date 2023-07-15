package com.zk.leetcode.贪心算法;

public class 跳跃游戏Ⅱ_45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int jump = jump(nums);
        System.out.println(jump);
    }

    //贪心，每次选择最远的距离
    public static int jump(int[] nums) {
        int n = nums.length;
        int end = 0;//记录一个元素跳跃范围内最远距离
        int maxPosition = 0;//记录每个元素最远距离
        int step = 0;
        for(int i = 0; i < n - 1; i++){
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == end){
                end = maxPosition;
                step++;
            }
        }

        return step;
    }
}
