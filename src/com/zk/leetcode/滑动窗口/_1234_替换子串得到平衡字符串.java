package com.zk.leetcode.滑动窗口;

import java.util.Arrays;

public class _1234_替换子串得到平衡字符串 {
    public static void main(String[] args) {
        String s1= "QWER"; //3
        String s2 = "WWQQRRRRQRQQ";
        int i1 = balancedString(s1);
        int i2 = balancedString(s2);
        System.out.println(i1);
        System.out.println(i2);
    }
    private static char[] words = {'Q', 'W', 'E', 'R'};
    public static int balancedString(String s) {
        int n = s.length();
        int[] counts = new int[26];


        for(int i = 0; i < n; i++){
            char t = s.charAt(i);
            counts[t - 'A']++;
        }
        int num = s.length() / 4;
        System.out.println(num);

        for(int i = 0; i < words.length; i++){
            if(counts[words[i] - 'A'] > num){
                counts[words[i] - 'A'] -= num;
            }else{
                counts[words[i] - 'A'] = 0;
            }
        }
        System.out.println(Arrays.toString(counts));
        if(check(counts, 0)){
            return 0;
        }
        // "WWQQRRRRQRQQ"
        int ans = Integer.MAX_VALUE;
        int r = 0;
        for(int l = 0; l < n; l++){
            while(r < n){
                counts[s.charAt(r++) - 'A']--;
                while(check(counts, 0)){
                    ans = Math.min(ans, r - l);
                    counts[s.charAt(l++) - 'A']++;
                }
            }
        }
        return ans;
    }

    public static int idx(char c) {
        return c - 'A';
    }

    public static boolean check(int[] cnt, int partial) {
        if (cnt[idx('Q')] > partial || cnt[idx('W')] > partial || cnt[idx('E')] > partial || cnt[idx('R')] > partial) {
            return false;
        }
        return true;
    }
}

















