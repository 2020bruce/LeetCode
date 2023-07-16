package com.zk.leetcode.动态规划;

public class _42_接雨水 {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int trap = trap(height);
        System.out.println(trap);
    }

    //动态规划，按列存水
    public static int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for(int i = 1; i < n - 1; i++){
            int min = Math.min(leftMax[i], rightMax[i]);
            if(min > height[i]){
                sum += min - height[i];
            }
        }

        return sum;
    }

}
