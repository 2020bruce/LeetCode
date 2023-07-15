package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 零钱兑换Ⅱ_518 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int change = change(5, coins);
        System.out.println(change);
    }

    /**
     * 组合必须以硬币1开始，且不能包含硬币1之后的其他硬币2， 3。假设这类方案数量为x1。
     * 组合必须以硬币2开始，且不能包含硬币2之后的其他硬币3。假设这类方案数量为x2。
     * 组合必须以硬币3开始。假设这类方案数量为x3。
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int c : coins){
            for(int i = c; i <= amount; i++){
                dp[i] += dp[i - c];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }
}
