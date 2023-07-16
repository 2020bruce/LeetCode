package com.zk.leetcode.单调栈;

import java.util.Stack;

public class _402_移掉K位数字 {
    public static void main(String[] args) {
        String num = "10001";
        int k = 4;
        String s = removeKdigits(num, k);
        System.out.println(s);
    }
    public static String removeKdigits(String num, int k) {
        int n  = num.length();
        Stack<Character> stack = new Stack<>();
        int removeCount = 0;

        int idx = 0;
        while(k > removeCount && idx < n){
            while(!stack.isEmpty() && k > removeCount && num.charAt(idx) < stack.peek()){
                stack.pop();
                removeCount++;
            }
            stack.push(num.charAt(idx++));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        while(idx < n){
            sb.append(num.charAt(idx++));
        }
        if(removeCount < k){
            sb.delete(sb.length() - (k - removeCount), sb.length());
        }
        int i;
        for(i = 0; i < sb.length(); i++){
            if(sb.charAt(i) != '0'){
                break;
            }
        }

        if(i == sb.length()){
            return "0";
        }

        return sb.substring(i, sb.length());
    }
}
