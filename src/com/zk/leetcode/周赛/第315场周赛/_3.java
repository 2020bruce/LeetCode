package com.zk.leetcode.周赛.第315场周赛;

public class _3 {
    public static void main(String[] args) {
        int num = 999999;
        boolean b = sumOfNumberAndReverse(num);
        System.out.println(b);
    }
    public static boolean sumOfNumberAndReverse(int num) {
        if(num == 0){
            return true;
        }
        int m = ((num / 10) + "").length();
        for(int i = (int)Math.pow(10, m - 1); i < num; i++){
            int reverse = 0;
            int n = (i + "").length();
            for(int k = 1; k <= n; k++){
                reverse += (int) (i % (Math.pow(10, k)) / (Math.pow(10, k - 1))) * Math.pow(10, n - k);
            }
            if(reverse > num){
                continue;
            }
            if(i + reverse == num){
                return true;
            }

        }
        return false;
    }
}
