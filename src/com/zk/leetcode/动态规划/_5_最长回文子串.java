package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _5_最长回文子串 {
    public static void main(String[] args) {
        String s = "cbbd";
        String palindrome = longestPalindrome(s);
        System.out.println(palindrome);
    }
    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        int max = 0;
        int l = 0, r = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i > 2){
                        dp[i][j] = dp[i + 1][j - 1];
                    }else{
                        dp[i][j] = true;
                    }

                }else{
                    dp[i][j] = false;
                }
                if(j - i > max && dp[i][j]){
                    max = j - i;
                    l = i;
                    r = j;
                }
            }
        }
        System.out.println(max);
        Arrays.stream(dp).forEach(o-> System.out.println(Arrays.toString(o)));
        return s.substring(l, r + 1);
    }
}
