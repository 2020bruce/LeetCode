package com.zk.greedy;

public class _376_WiggleSubsequence {
    public static void main(String[] args) {
        // {1,7,4,9,2,5}  6
        int[] nums = {1,17,5,10,13,15,10,5,16,8}; // 7
        int length = wiggleMaxLength(nums);
        System.out.println(length);
    }
    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int up = 1, down = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] > nums[i - 1]){
                up = down + 1;
            }else if(nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }
}
