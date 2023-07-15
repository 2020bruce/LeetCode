package com.zk.leetcode.哈希表;

import java.util.HashSet;

public class _202_快乐数 {
    public static void main(String[] args) {
        int n = 2;
        boolean happy = isHappy(n);
        System.out.println(happy);
    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = n;
        while(true){
            sum = getSum(sum);
            if(sum == 1){
                return true;
            }else{
                if(set.contains(sum)){
                    return false;
                }else{
                    set.add(sum);
                }
            }
        }

    }

    private static int getSum(int n) {
        int sum = 0;
        while(n > 0) {
            int temp = n % 10;
            sum += temp*temp;
            n /= 10;
        }
        return sum;
    }

}
