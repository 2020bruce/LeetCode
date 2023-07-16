package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _678_有效的括号字符串 {
    public static void main(String[] args) {
        String s = "(*())";
        boolean b = checkValidStringBest(s);
        System.out.println(b);
    }

    //贪心算法
    public static boolean checkValidStringBest(String s){
        int n = s.length();
        int minCount = 0;
        int maxCount = 0;
        for(int i = 0; i < n; i++){
            int c = s.charAt(i);
            if(c == '('){
                minCount++;
                maxCount++;
            }else if(c == ')'){
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if(maxCount < 0){
                    return false;
                }
            }else{
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }

    //动态规划
    public static boolean checkValidString(String s) {
        int n = s.length();
        if(n == 1){
            if(s.charAt(0) == '*'){
                return true;
            }else{
                return false;
            }
        }else if(n == 2){
            if(s.charAt(0) == ')'){
                return false;
            }else if(s.charAt(0) == '*'){
                if(s.charAt(1) == '('){
                    return false;
                }
                return true;
            }else{
                if(s.charAt(1) == '*' || s.charAt(1) == ')'){
                    return true;
                }else{
                    return false;
                }
            }
        }

        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '*'){
                dp[i][i] = true;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                int l = s.charAt(i);
                int r = s.charAt(j);
                if((l == '(' || l == '*') && (r == ')' || r == '*')){
                    if(j - i == 1){
                        dp[i][j] = true;
                        continue;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                for(int k = i + 1; k < j; k++){
                    dp[i][j] |= (dp[i][k] && dp[k + 1][j]) || (dp[i][k - 1] && dp[k][j]);
                }
            }
        }
        for(boolean[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[0][n - 1];
    }
}
