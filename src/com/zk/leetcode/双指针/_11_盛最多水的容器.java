package com.zk.leetcode.双指针;

public class _11_盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }
    public static int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int i = 0, j = n - 1;
        while(i < j){
            int w = j - i;
            int h = 0;
            if(height[i] > height[j]){
                h = height[j];
                j--;
            }else{
                h = height[i];
                i++;
            }
            if(w * h > res){
                res = w * h;
            }
        }
        return res;
    }
}





















