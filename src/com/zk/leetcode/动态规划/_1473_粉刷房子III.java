package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _1473_粉刷房子III {
    public static void main(String[] args) {
        int[] houses = {0,0,0,0,0};
        int[][] cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int m = 5, n = 2, target = 3;
        int minCost = minCost(houses, cost, m, n, target);
        System.out.println(minCost);
    }
    static final int MAX = Integer.MAX_VALUE / 2;
    public static int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        //dp[i][j][k] 表示前i个房子，第i个房子涂上第j + 1个颜色，并且它属于第k个街区时，需要的最少花费。
        int[][][] dp = new int[m][n][target + 1];
        for(int i = 0; i < m; i++){
            houses[i]--;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], MAX);
                dp[i][j][0] = 0;
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(houses[i] != -1 && houses[i] != j){
                    continue;
                }
                for(int k = 1; k <= target; k++){
                    for(int t = 0; t < n; t++){// 设第i - 1个房子的颜色为t
                        if(j == t){// 属于同一街区
                            if(i == 0){
                                if(k == 1){
                                    dp[i][j][k] = 0;
                                }
                            }else{
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][t][k]);
                            }

                        }else if(i > 0 && k > 1){// 属于不同街区
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][t][k - 1]);
                        }
                    }
                    if (dp[i][j][k] != MAX && houses[i] == -1) {
                        dp[i][j][k] += cost[i][j];
                    }
                }
            }
        }


        int ans = MAX;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp[m - 1][j][target]);
        }

        return ans == MAX ? -1 : ans;
    }
}
































