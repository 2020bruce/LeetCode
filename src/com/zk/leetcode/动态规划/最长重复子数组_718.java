package com.zk.leetcode.动态规划;

public class 最长重复子数组_718 {
    public static void main(String[] args) {
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {0,0,0,0,0};
        int length = findLength(nums1, nums2);
        System.out.println(length);
    }
    public static int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        int result = 0;
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }


        return result;
    }
}
