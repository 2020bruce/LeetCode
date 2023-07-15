package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _10_正则表达式匹配 {
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*ip*.";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }
    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for(int i = 1; i <= n; i++){
            char c1 = p.charAt(i - 1);
            if(c1 == '*'){
                char c2 = p.charAt(i - 1);
                if(c2 != '.'){
                    dp[0][i] = dp[0][i - 2];
                }
            }
        }
        for(int i = 1; i <= m; i++){
            char sc = s.charAt(i - 1);
            for(int j = 1; j <= n; j++){
                char pc = p.charAt(j - 1);
                if(sc == pc){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    if(pc == '*'){
                        char pc2 = p.charAt(j - 2);
                        if(sc == pc2){
                            dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                        }else if(pc2 == '.'){
                            boolean flag = false;
                            for(int k = 0; k <= i; k++){
                                if(dp[k][j - 2]){
                                    flag = true;
                                    break;
                                }
                            }
                            dp[i][j] = flag;
                        }else{
                            dp[i][j] = dp[i][j - 2];
                        }
                    }else if(pc == '.'){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        Arrays.stream(dp).forEach(o-> System.out.println(Arrays.toString(o)));
        return dp[m][n];
    }
}





























