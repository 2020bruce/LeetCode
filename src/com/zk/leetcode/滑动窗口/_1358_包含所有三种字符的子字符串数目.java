package com.zk.leetcode.滑动窗口;

public class _1358_包含所有三种字符的子字符串数目 {
    public static void main(String[] args) {
        String s = "abcabc";
        int i = numberOfSubstrings(s);
        System.out.println(i);
    }
    public static int numberOfSubstrings(String s) {
        int[] arr = new int[3];
        int n = s.length();
        int res = 0;
        int l = 0;
        for(int r = 0; r < n; r++){
            arr[s.charAt(r) - 'a']++;
            while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0){
                res += n - r;
                arr[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return res;
    }
}
