package com.zk.leetcode.哈希表;

public class _1027_最长等差数列 {
    public static void main(String[] args) {
        int[] nums = {20,1,15,3,10,5,8};
        int i = longestArithSeqLengthBest(nums);
        System.out.println(i);
    }

    public static int longestArithSeqLengthBest(int[] nums){
        int n = nums.length;
        if(n < 3){
            return n;
        }
        int[][] dp = new int[n][1001];
        int maxLength = 0;
        for(int k = 1; k < n; k++){
            for(int j = 0; j < k; j++){
                int d = nums[k] - nums[j] + 500;
                dp[k][d] = dp[j][d] + 1;
                maxLength = Math.max(maxLength, dp[k][d]);
            }
        }
        return maxLength + 1;
    }

    public static int longestArithSeqLength(int[] nums) {
        int n= nums.length;
        if(n == 2){
            return n;
        }
        int res = 2;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int tempRes = 2;
                int begin = nums[j];
                int beginGap = nums[j] - nums[i];
                for(int k = j + 1; k < n; k++){
                    if(nums[k] - begin == beginGap){
                        begin = nums[k];
                        tempRes++;
                    }
                }
                res = Math.max(res, tempRes);
            }
        }

        return res;
    }

}
