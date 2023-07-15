package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class _282_给表达式添加运算符 {
    public static void main(String[] args) {
        String num = "105";
        int target = 5;
        List<String> list = addOperators(num, target);
        assert list != null;
        list.forEach(o-> System.out.println(o + " "));
    }
    static List<String> ans = new ArrayList<>();
    public static List<String> addOperators(String num, int target) {
        StringBuilder sb = new StringBuilder();
        backtrack(num, target, sb, 0, 0, 0);
        return ans;
    }
    static char[] operators = {'+', '-', '*'};
    private static void backtrack(String num, int target, StringBuilder sb, int begin, int value, int res) {
        int n = num.length();
        if(begin == n){
            if(res == target){
                ans.add(sb.toString());
            }
            return;
        }
        int signIndex = sb.length();
        if (begin > 0) {
            sb.append(0);
        }
        System.out.println(sb.toString());

        int sVal = 0;
        for(int i = begin; i < n && (i == begin || num.charAt(begin) != '0'); i++){
            sVal = 10 * sVal + (num.charAt(i) - '0');
            sb.append(num.charAt(i));
            if (begin == 0) {
                backtrack(num, target, sb, i + 1, sVal, sVal);
            } else{
                for(char operator : operators){
                    sb.setCharAt(signIndex, operator);
                    if(operator == '+'){
                        backtrack(num, target, sb, i + 1, sVal, res + sVal);
                    }else if(operator == '-'){
                        backtrack(num, target, sb, i + 1, -sVal, res - sVal);
                    }else{
                        backtrack(num, target, sb, i + 1, value * sVal, res - value + value * sVal);
                    }
                }
            }
        }
        sb.setLength(signIndex);


    }

}

















