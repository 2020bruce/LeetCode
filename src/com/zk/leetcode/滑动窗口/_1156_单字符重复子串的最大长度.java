package com.zk.leetcode.滑动窗口;

public class _1156_单字符重复子串的最大长度 {
    public static void main(String[] args) {
        String text = "aaaaa";
        int i = maxRepOpt1(text);
        System.out.println(i);
    }
    public static int maxRepOpt1(String text) {
        int n = text.length();
        int[] cnt = new int[26];
        for(int i = 0; i < n; i++){
            cnt[text.charAt(i) - 'a']++;
        }
        char now = text.charAt(0);
        int res = 1;
        int count = 1;
        for(int r = 1; r < n; r++){
            if(text.charAt(r) == now){
                count++;
            }else{
                int tempIndex = r + 1;
                while(tempIndex < n && text.charAt(tempIndex) == now){
                    tempIndex++;
                    count++;
                }
                if(cnt[now - 'a'] > count){
                    count++;
                }
                res = Math.max(res, count);
                now = text.charAt(r);
                count = 1;
            }
        }
        if(cnt[now - 'a'] > count){
            count++;
        }
        res = Math.max(res, count);
        return res;
    }
}
