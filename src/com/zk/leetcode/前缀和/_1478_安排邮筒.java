package com.zk.leetcode.前缀和;

import java.util.Arrays;

public class _1478_安排邮筒 {
    public static void main(String[] args) {
        int[] houses = {1,4,8,10,20};
        int k = 3;
        int distance = minDistance(houses, k);
        System.out.println(distance);
    }
    public static int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int n = houses.length;

        int[][] medSum = new int[n][n];
        for(int i = n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                medSum[i][j] = medSum[i + 1][j - 1] - houses[i] + houses[j];
            }
        }

        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for(int i = 0; i < n; i++){
            dp[i][1] = medSum[0][i];
            for(int j = 2; j <= k && j <= i + 1; j++){
                for(int m = 0; m < i; m++){
                    dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + medSum[m + 1][i]);
                }
            }
        }

        return dp[n - 1][k];
    }
}




















