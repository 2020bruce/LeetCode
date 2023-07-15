package com.zk.leetcode.哈希表;

public class _424_替换后的最长重复字符 {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int i = characterReplacement(s, k);
        System.out.println(i);
    }
    public static int characterReplacement(String s, int k) {
        int changeCount = k;
        int n = s.length();
        if(n <= changeCount){
            return n;
        }
        int[] map = new int[26];
        int maxNum = 0;
        int left = 0;
        int right = 0;
        while(right < n){
            int t = s.charAt(right) - 'A';
            map[t]++;
            maxNum = Math.max(maxNum, map[t]);
            if(right - left + 1 - maxNum > k){
                map[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}















































































