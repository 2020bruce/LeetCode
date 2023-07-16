package com.zk.leetcode.滑动窗口;

public class _1456_定长子串中元音的最大数目 {
    public static void main(String[] args) {
        String s = "tryhard";
        int k = 4;
        int maxVowels = maxVowels(s, k);
        System.out.println(maxVowels);
    }
    public static int maxVowels(String s, int k) {
        int n = s.length();
        boolean[] isVowel = new boolean[26];
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        for(char v : vowel){
            isVowel[v - 'a'] = true;
        }
        int ans = 0, t = 0;
        for(int i = 0; i < k; i++){
            if(isVowel[s.charAt(i) - 'a']) t++;
        }
        ans = Math.max(ans, t);
        for(int i = k; i < n; i++){
            if(isVowel[s.charAt(i) - 'a']) t++;
            if(isVowel[s.charAt(i - k) - 'a']) t--;
            ans = Math.max(ans, t);
        }
        return ans;
    }
}































