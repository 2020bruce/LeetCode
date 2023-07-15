package com.zk.leetcode.动态规划;

public class 两个字符串的删除操作_583 {
    public static void main(String[] args) {
        String word1 = "seate";
        String word2 = "seabte";
        int distance = minDistance(word1, word2);
        System.out.println(distance);
    }
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= n1; i++) dp[i][0] = i;
        for (int j = 0; j <= n2; j++) dp[0][j] = j;
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
