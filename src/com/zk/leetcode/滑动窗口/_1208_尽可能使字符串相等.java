package com.zk.leetcode.滑动窗口;

import java.util.Arrays;

public class _1208_尽可能使字符串相等 {
    public static void main(String[] args) {
        String s = "abcd", t = "acde";
        int maxCost = 0;
        int i = equalSubstring(s, t, maxCost);
        System.out.println(i);
    }
    public static int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] sub = new int[n];
        for(int i = 0; i < n; i++){
            sub[i] = Math.abs(cs[i] - ct[i]);
        }
        System.out.println(Arrays.toString(sub));
        int ans = 0;
        int left = 0;
        int target = maxCost;
        for(int right = 0; right < n; right++){
            target -= sub[right];
            while(target < 0){
                target += sub[left];
                left++;
            }
            if(target >= 0){
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}
