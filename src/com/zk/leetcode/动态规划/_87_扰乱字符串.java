package com.zk.leetcode.动态规划;

import java.util.HashMap;
import java.util.Map;

public class _87_扰乱字符串 {
    public static void main(String[] args) {
        String s1 = "great", s2 = "rgeat";
        boolean scramble = isScramble(s1, s2);
        System.out.println(scramble);
    }
    static String s1;
    static String s2;
    static int[][][] memo;
    public static boolean isScramble(String s1, String s2) {
        int n = s1.length();
        _87_扰乱字符串.s1 = s1;
        _87_扰乱字符串.s2 = s2;
        memo = new int[n][n][n + 1];
        return dfs(0, 0, n);
    }

    private static boolean dfs(int i1, int i2, int n) {
        if(memo[i1][i2][n] != 0){
            return memo[i1][i2][n] == 1;
        }

        if(s1.substring(i1, i1 + n).equals(s2.substring(i2, i2 + n))){
            memo[i1][i2][n] = 1;
            return true;
        }

        if(!checkIfSimilar(i1, i2, n)){
            memo[i1][i2][n] = -1;
            return false;
        }

        for(int i = 1; i < n; i++){
            if(dfs(i1, i2, i) && dfs(i1 + i, i2 + i, n - i)){
                memo[i1][i2][n] = 1;
                return true;
            }
            if(dfs(i1, i2 + n - i, i) && dfs(i1 + i, i2, n - i)){
                memo[i1][i2][n] = 1;
                return true;
            }

        }
        memo[i1][i2][n] = -1;
        return false;
    }

    private static boolean checkIfSimilar(int i1, int i2, int n){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = i1; i < i1 + n; i++){
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = i2; i< i2 + n; i++){
            char c = s2.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }


}

































