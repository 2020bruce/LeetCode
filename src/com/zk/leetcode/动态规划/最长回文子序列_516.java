package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 最长回文子序列_516 {
    public static void main(String[] args) {
        String s = "bbbab";
        int i = longestPalindromeSubseq(s);
        System.out.println(i);
    }
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 1){
            return 1;
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    dp[j][i] = 2 + dp[j + 1][i - 1];

                }else{
                    dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
                }
            }
        }
        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[0][n - 1];
    }


}
