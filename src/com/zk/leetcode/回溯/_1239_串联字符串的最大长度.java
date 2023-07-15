package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1239_串联字符串的最大长度 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("cha","r","act","ers"));
        int maxLength = maxLength(list);
        System.out.println(maxLength);
    }

    static int maxLen = 0;
    static boolean[] isExistChar;
    public static int maxLength(List<String> arr) {
        isExistChar = new boolean[26];
        StringBuilder curString = new StringBuilder();
        int n = arr.size();
        for(int i = 0; i < n; i++){
            backtrack(arr, i, curString);
        }
        return maxLen;
    }

    private static void backtrack(List<String> arr, int stringIdx, StringBuilder curString) {
        String s = arr.get(stringIdx);
        for(int i = 0; i < s.length(); i++) {
            if (isExistChar[s.charAt(i) - 'a']) {
                for(int j = 0; j  < i; j++){
                    isExistChar[s.charAt(j) - 'a'] = false;
                }
                return;
            }else{
                isExistChar[s.charAt(i) - 'a'] = true;
            }
        }
        curString.append(s);
        System.out.println(curString.toString());
        maxLen = Math.max(maxLen, curString.toString().length());
        int n = arr.size();
        for(int i = stringIdx + 1; i < n; i++){
            backtrack(arr, i, curString);
        }
        for(int j = 0; j < s.length(); j++){
            isExistChar[s.charAt(j) - 'a'] = false;
        }


        curString.delete(curString.toString().length() - s.length(), curString.toString().length());
    }
}



















