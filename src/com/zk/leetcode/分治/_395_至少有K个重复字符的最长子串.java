package com.zk.leetcode.分治;

public class _395_至少有K个重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        int i = longestSubstring(s, k);
        System.out.println(i);
    }
    public static int longestSubstring(String s, int k) {
        return merge(s, 0, s.length() - 1, k);
    }
    public static int merge(String s, int l, int r, int k){
        int n = s.length();
        int[] cnt = new int[26];
        for(int i = l;i <= r; i++){
            cnt[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for(int i = 0; i < 26; i++){
            if(cnt[i] > 0 && cnt[i] < k ){
                split = (char)(i + 'a');
                break;
            }
        }
        if(split == 0){
            return r - l + 1;
        }

        int i = l;
        int res = 0;
        while(i <= r){
            while(i <= r && split == s.charAt(i)){
                i++;
            }
            if(i > r){
                break;
            }
            int start = i;
            while(i <= r && s.charAt(i) != split){
                i++;
            }
            int length = merge(s, start, i - 1, k);
            res = Math.max(res, length);
        }

        return res;
    }
}


























































