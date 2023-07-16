package com.zk.leetcode.双指针;

public class _633_平方数之和 {
    public static void main(String[] args) {
        int c = 5;
        boolean b = judgeSquareSum(c);
        System.out.println(b);
    }
    public static boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long)Math.sqrt(Integer.MAX_VALUE);
        while(left <= right){
            long sum = left * left + right * right;
            if(sum == c){
               return true;
            }else if(sum > c){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
}
