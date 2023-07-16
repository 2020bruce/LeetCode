package com.zk.leetcode.回溯;

public class _306_累加数 {
    public static void main(String[] args) {
        String s = "112358";
        boolean b = isAdditiveNumber(s);
        System.out.println(b);

    }
    public static boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i = 1; i < n; i++){
            long k = 0;
            for(int j = 0; j < i; j++){
                k = k * 10 + (num.charAt(j) - '0');
                long l = 0;
                if(j > 0 && num.charAt(0) == '0'){
                    break;
                }
                if(i - j > 1 && num.charAt(j + 1) == '0'){
                    continue;
                }
                for(int m = j + 1; m <= i; m++){
                    l = 10 * l + (num.charAt(m) - '0');
                }
                if(backtrack(num, k, l, i + 1)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(String num, long k, long l, int begin) {
        int n = num.length();
        long t = 0;
        for(int i = begin; i < n; i++){
            t = t * 10 + (num.charAt(i) - '0');
            if(k + l == t){
                if(i == n - 1 || backtrack(num, l, t, i + 1)){
                    return true;
                }
            }
            if(num.charAt(begin) == '0' || t > k + l){
                break;
            }
        }
        return false;
    }
}
