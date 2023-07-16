package com.zk.leetcode.动态规划;

public class _877_石子游戏 {
    public static void main(String[] args) {
        int[] piles = {5,3,4,5};
        boolean b = stoneGame(piles);
        System.out.println(b);
    }
    public static boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }
}
















