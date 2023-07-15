package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _132_分割回文串II {
    public static void main(String[] args) {
        String s = "aab";
        int minCut = minCut(s);
        System.out.println(minCut);
    }
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        for(int i = n; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                boolean equal = s.charAt(i) == s.charAt(j);
                if(j - i >= 2){
                    dp[i][j] = equal && dp[i + 1][j - 1];
                }else{
                    dp[i][j] = equal;
                }
            }
        }
        Arrays.stream(dp).forEach(o-> System.out.println(Arrays.toString(o)));

        int[] f = new int[n];
        for(int i = 0; i < n; i++){
            if(dp[0][i]){
                f[i] = 0;
            }else{
                for(int j = 0; j < i; j++){
                    if(dp[j + 1][i]){
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }

}




































