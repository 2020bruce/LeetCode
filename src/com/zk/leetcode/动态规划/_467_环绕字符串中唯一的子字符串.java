package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _467_环绕字符串中唯一的子字符串 {
    public static void main(String[] args) {
        String p = "zab";
        int substring = findSubstringInWraproundString(p);
        System.out.println(substring);
    }
    public static int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int n = p.length();
        int k = 0;
        for(int i = 0; i < n; i++){
            if(i > 0 && ((p.charAt(i) - p.charAt(i - 1)) + 26) % 26 == 1){
                k++;
            }else{
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }
}
