package com.zk.leetcode.回溯;

import java.util.*;

public class _301_删除无效的括号 {
    public static void main(String[] args) {
        String s = "(h(d()(((c)())()))()";
        List<String> list = removeInvalidParentheses(s);
        list.forEach(System.out::println);
    }
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static List<String> removeInvalidParentheses(String s) {
        backtrack(s, 0);
        int maxLen = 0;
        for(String str : set){
            if(str.length() > maxLen){
                maxLen = str.length();
            }
        }
        List<String> ans = new ArrayList<>();
        for(String str : set){
            if(str.length() == maxLen){
                ans.add(str);
            }
        }
        return ans;
    }

    private static void backtrack(String s, int idx) {
        int n = s.length();
        if(n == idx){
            if(isValid(sb.toString())){
                set.add(sb.toString());
            }
            return;
        }
        for(int i = 0; i < 2; i++){
            if(i == 0){
                sb.append(s.charAt(idx));
                backtrack(s, idx + 1);
                sb.deleteCharAt(sb.length() - 1);
            }else{
                backtrack(s, idx + 1);
            }
        }

    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
