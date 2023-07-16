package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class _784_字母大小写全排列 {
    public static void main(String[] args) {
        String s = "a1b2";
        List<String> list = letterCasePermutation(s);
        list.forEach(o-> System.out.print(o + " "));

    }
    static List<String> list = new ArrayList<>();
    public static List<String> letterCasePermutation(String s) {
        StringBuilder sb = new StringBuilder();
        backtrack(s, sb, 0);
        return list;
    }
    private static void backtrack(String s, StringBuilder sb, int idx) {
        int n = s.length();
        if(idx == n){
            list.add(sb.toString());
            return;
        }
        char c = s.charAt(idx);
        sb.append(c);
        backtrack(s, sb, idx + 1);
        if(c >= 65 && c <= 90){
            sb.setCharAt(sb.length() - 1, (char)(c + 32));
            backtrack(s, sb, idx + 1);
        }else if(c >= 97 && c <= 122){
            sb.setCharAt(sb.length() - 1, (char)(c - 32));
            backtrack(s, sb, idx + 1);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
