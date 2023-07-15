package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _44_通配符匹配 {
    public static void main(String[] args) {
        String s = "acdcb";
        String p = "a*c?b";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            char c = p.charAt(i - 1);
            if(c == '*'){
                dp[0][i] = dp[0][i - 1];
            }
        }
        for(int i = 1; i <= m; i++){
            char sc = s.charAt(i - 1);
            for(int j = 1; j <= n; j++){
                char pc = p.charAt(j - 1);
                if(sc == pc){
                    dp[i][j] = dp[i -  1][j - 1];
                }else{
                    if(pc == '*'){
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    }else if(pc == '?'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        Arrays.stream(dp).forEach(o-> System.out.println(Arrays.toString(o)));
        return dp[m][n];
    }
}
