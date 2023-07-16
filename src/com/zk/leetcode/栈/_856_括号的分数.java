package com.zk.leetcode.栈;

import java.util.Stack;

public class _856_括号的分数 {
    public static void main(String[] args) {
        String s = "(()(()))";
        int score = scoreOfParentheses(s);
        System.out.println(score);
    }
    public static int scoreOfParentheses(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 0; i < n; i++){
            if(c[i] == '('){
                st.push(0);
            }else{
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }

        return st.pop();
    }
}














