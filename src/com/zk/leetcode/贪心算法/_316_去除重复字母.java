package com.zk.leetcode.贪心算法;

import java.util.Stack;

public class _316_去除重复字母 {
    public static void main(String[] args) {
        String s = "bbcaac";
        String s1 = removeDuplicateLetters(s);
        System.out.println(s1);
    }
    public static String removeDuplicateLetters(String s) {
        char[] c = s.toCharArray();
        int[] nums = new int[26];
        for(int i = 0; i < s.length(); i++){
            nums[c[i] - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char t = s.charAt(i);
            if(stack.contains(t)){
                nums[t - 'a']--;
                continue;
            }
            while(!stack.isEmpty() && t < stack.peek() && nums[stack.peek() - 'a'] > 1){
                char ch = stack.pop();
                nums[ch - 'a']--;
            }
            stack.push(t);
        }
        char[] res = new char[stack.size()];
        for(int i = 0; i < stack.size(); i++){
            res[i] = stack.get(i);
        }
        return new String(res);
    }
}




















