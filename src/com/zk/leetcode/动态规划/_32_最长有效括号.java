package com.zk.leetcode.动态规划;

public class _32_最长有效括号 {
    public static void main(String[] args) {
        String s1 = ")()())";
        String s2 = "((())";
        int i1 = longestValidParentheses(s1);
        int i2 = longestValidParentheses(s2);
        System.out.println(i1);
        System.out.println(i2);
    }
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int ans = 0;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
