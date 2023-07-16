package com.zk.leetcode.贪心算法;

public class _738_单调递增的数字 {
    public static void main(String[] args) {
        int n = 1000;
        int i = monotoneIncreasingDigits(n);
        System.out.println(i);
    }
    public static int monotoneIncreasingDigits(int n) {
        if(n < 10){
            return n;
        }
        String s = n + "";
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i = len - 1; i >= 1; i--){
            if(chars[i] < chars[i - 1]){
                int j = i - 1;
                chars[j] = (char)(chars[j] - 1);
                for(j = j + 1; j < len; j++){
                    chars[j] = '9';
                }

            }
        }

        String res = new String(chars);
        return Integer.parseInt(res);
    }
}
