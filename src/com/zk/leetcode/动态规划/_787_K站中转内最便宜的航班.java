package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _787_K站中转内最便宜的航班 {
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{3,4,4},{2,5,6},{4,7,10},{9,6,5},{7,4,4},{6,2,10},{6,8,6},{7,9,4},{1,5,4},{1,0,4},{9,7,3},{7,0,5},{6,5,8},{1,7,6},{4,0,9},{5,9,1},{8,7,3},{1,2,6},{4,1,5},{5,2,4},{1,9,1},{7,8,10},{0,4,2},{7,2,8}};
        int src = 6, dst = 0, k = 7;
        int price = findCheapestPrice(n, edges, src, dst, k);
        System.out.println(price);
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[k + 2][n];//表示第k步从src到n的距离

        for(int i = 0; i < k + 2; i++){
            Arrays.fill(dp[i], 1000000);
        }
        for(int i = 0; i < k + 2; i++){
            dp[i][src] = 0;
        }

        for(int i = 1; i <= k + 1; i++){
            for(int[] flight : flights){
                int from = flight[0], to = flight[1], cost = flight[2];
                dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + cost);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k + 2; i++){
            if(dp[i][dst] < res){
                res = dp[i][dst];
            }
        }
        for(int i = 0; i < k + 2; i++){
            System.out.println(Arrays.toString(dp[i]));
        }

        return res == 1000000 ? -1 : res;
    }

}
















