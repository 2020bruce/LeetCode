package com.zk.leetcode.动态规划;

public class 旋转数字_788 {
    public static void main(String[] args) {
        int n = 10;
        int i = rotatedDigits(n);
        System.out.println(i);
    }
    public static int rotatedDigits(int n) {
        String s = "";
        char[] chars = null;
        int res = 0;
        for(int i = 1; i <= n; i++){
            s = i + "";
            chars = s.toCharArray();
            int j = 0;
            for(; j < chars.length; j++){
                if(chars[j] == '3' || chars[j] == '4' || chars[j] == '7'){
                    break;
                }
            }
            if(j != chars.length){
                continue;
            }
            for(int k = 0; k < chars.length; k++){
                if(chars[k] == '2' || chars[k] == '5' || chars[k] == '6' || chars[k] == '9'){
                    res++;
                    break;
                }
            }
        }

        return res;
    }
}
