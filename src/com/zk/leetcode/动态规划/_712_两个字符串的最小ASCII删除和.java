package com.zk.leetcode.动态规划;

public class _712_两个字符串的最小ASCII删除和 {
    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        int sum = minimumDeleteSum(s1, s2);
        System.out.println(sum);
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            dp[i][0] = dp[i - 1][0] + s1.codePointAt(i - 1);
        }
        for(int i = 1; i <= n; i++){
            dp[0][i] = dp[0][i - 1] + s2.codePointAt(i - 1);
        }
        for(int i = 1; i <= m; i++){
            int c1 = s1.codePointAt(i - 1);
            for(int j = 1; j <= n; j++){
                int c2 = s2.codePointAt(j - 1);
                if(c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c2);
                }

            }
        }
        return dp[m][n];
    }
}
























