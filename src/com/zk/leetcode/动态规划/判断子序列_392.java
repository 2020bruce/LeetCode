package com.zk.leetcode.动态规划;

public class 判断子序列_392 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean b = isSubsequence(s, t);
        System.out.println(b);
    }

    public static boolean isSubsequence(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        boolean[][] dp = new boolean[ls + 1][lt + 1];
        for(int i = 0; i <= lt; i++){
            dp[0][i] = true;
        }
        for(int i = 1; i <= ls; i++ ){
            for(int j = i; j <= lt; j++){
                if(dp[i][j - 1]){
                    dp[i][j] = true;//如果s是t中较短串的子序列，那s一定是t串中较长串的子序列
                }else{
                    dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == t.charAt(j - 1);
                }
            }
        }
        return dp[ls][lt];

    }
}
