package com.zk.leetcode.动态规划;

public class _91_解码方法 {
    public static void main(String[] args) {
        //String s = "2611055971756562";
        String s = "2101";
        int i = numDecodings(s);
        System.out.println(i);
    }
    public static int numDecodings(String s) {
        int n = s.length();
        if(s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2'){
                    return 0;
                }else{
                    dp[i + 1] = dp[i - 1];
                }
            }else if((s.charAt(i) <= '6' && s.charAt(i - 1) == '2') || (s.charAt(i - 1) < '2')){
                if(s.charAt(i - 1) == '0'){
                    dp[i + 1] = dp[i];
                }else{
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
            }else{
                dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }
}
















































