package com.zk.leetcode.贪心算法;

import java.util.Stack;

public class 使括号有效的最少添加_921 {
    public static void main(String[] args) {
        String s = "())";
        int i = minAddToMakeValid(s);
        System.out.println(i);

    }
    public static int minAddToMakeValid(String s) {
        if(s.length() == 1){
            return 1;
        }
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                if(!stack.isEmpty()){
                    Character c = stack.pop();
                }else{
                    sum++;
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            sum++;
        }
        return sum;
    }
}
