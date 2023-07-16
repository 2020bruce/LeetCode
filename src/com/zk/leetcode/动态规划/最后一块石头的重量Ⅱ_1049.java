package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 最后一块石头的重量Ⅱ_1049 {
    public static void main(String[] args) {
        int[] stones = {100, 50};
        int i = lastStoneWeightII(stones);
        System.out.println(i);
    }
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int all = 0;
        for(int stone : stones){
            sum += stone;
        }
        all = sum;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        int index = 0;
        for(int stone : stones){
            for(int i = sum; i >= stone; i--){
                dp[i] = dp[i] || dp[i - stone];
                if(i > index && dp[i]){
                    index = i;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return all - index - index;
    }
}












