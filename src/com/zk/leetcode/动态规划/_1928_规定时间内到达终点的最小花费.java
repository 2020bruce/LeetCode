package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _1928_规定时间内到达终点的最小花费 {
    public static void main(String[] args) {
        int maxTime = 29;
        int[][] edges = {{0,1,10},{1,2,10},{2,5,10},{0,3,1},{3,4,10},{4,5,15}};
        int[] passingFees = {5,1,2,20,20,3};
        int cost = minCost(maxTime, edges, passingFees);
        System.out.println(cost);
    }
    public static int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int[][] minCost = new int[maxTime + 1][n];
        for(int i = 0; i < maxTime + 1; i++){
            Arrays.fill(minCost[i], 1000000);
        }
        minCost[0][0] = passingFees[0];

        for(int i = 1; i < maxTime + 1; i++){
            for(int[] edge : edges){
                int from = edge[0], to = edge[1], cost = edge[2];
                if(i >= cost){
                    minCost[i][from] = Math.min(minCost[i][from], minCost[i - cost][to] + passingFees[from]);
                    minCost[i][to] = Math.min(minCost[i][to], minCost[i - cost][from] + passingFees[to]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i <= maxTime; i++){
            if(minCost[i][n - 1] < res){
                res = minCost[i][n - 1];
            }
        }

        return res == 1000000 ? -1 : res;
    }
}















