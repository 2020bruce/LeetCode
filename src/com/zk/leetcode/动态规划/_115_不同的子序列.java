package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _115_不同的子序列 {
    public static void main(String[] args) {
        String s = "aaaaa", t = "aaa";
        int distinct = numDistinct(s, t);
        System.out.println(distinct);
    }
    public static int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i <= m; i++){
            char tc = t.charAt(i - 1);
            for(int j = 1; j <= n; j++){
                char sc = s.charAt(j - 1);
                if(tc == sc){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        Arrays.stream(dp).forEach(o-> System.out.println(Arrays.toString(o)));
        return dp[m][n];
    }
}



























