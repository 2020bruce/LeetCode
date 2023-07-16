package com.zk.leetcode.动态规划;

public class 回文子串_647 {
    public static void main(String[] args) {
        int i = countSubstrings2("abc");
        System.out.println(i);
    }

    //dp[i][j] 表示[i,j]之间的字符串是回文字符串
    public static int countSubstrings2(String s){
        int n =  s.length();
        boolean[][] dp = new boolean[n][n];

        int all = 0;

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        dp[i][j] = true;
                        all++;
                    }else if(dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        all++;
                    }

                }
            }
        }
        return all;
    }

    public static int countSubstrings(String s) {
        int n = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPalindromeString(s.substring(i, j + 1))){
                    n++;
                }
            }
        }
        return n;
    }

    private static boolean isPalindromeString(String s){
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }


}
