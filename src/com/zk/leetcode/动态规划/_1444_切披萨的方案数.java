package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _1444_切披萨的方案数 {
    public static void main(String[] args) {
        String[] pizza = {".A","AA","A."};
        int k = 3;
        int ways = ways(pizza, k);
        System.out.println(ways);
    }

    public static int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length(), mod = 1000000007;
        int[][][] dp = new int[m + 1][n + 1][k + 1];
        int[][] sums = new int[m + 1][n + 1];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                sums[i][j] = pizza[i].charAt(j) == 'A' ? 1 : 0;
                sums[i][j] += sums[i + 1][j] + sums[i][j + 1] - sums[i + 1][j + 1];
            }
        }
        Arrays.stream(sums).forEach(o-> System.out.println(Arrays.toString(o)));

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(sums[i][j] > 0){
                    dp[i][j][1] = 1;
                }
                for(int p = 2; p <= k; p++){
                    //横着切
                    for(int q = m - i - 1; q >= 1; q--){
                        if(sums[i][j] - sums[i + q][j] > 0){
                            dp[i][j][p] = (dp[i][j][p] + dp[i + q][j][p - 1]) % mod;
                        }
                    }
                    //竖着切
                    for(int q = n - j - 1; q >= 1; q--) {
                        if(sums[i][j] - sums[i][j + q] > 0) {
                            dp[i][j][p] = (dp[i][j][p] + dp[i][j + q][p - 1]) % mod;
                        }
                    }
                }
            }
        }


        return dp[0][0][k];

    }
}
































