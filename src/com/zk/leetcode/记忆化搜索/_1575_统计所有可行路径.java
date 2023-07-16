package com.zk.leetcode.记忆化搜索;

import java.util.Arrays;

public class _1575_统计所有可行路径 {
    public static void main(String[] args) {
        int[] locations = {2,3,2};
        int start = 0, finish = 2, fuel = 1;
        int routes = countRoutes(locations, start, finish, fuel);
        System.out.println(routes);
    }
    static int[][] dp;
    static int MOD = 1000000007;
    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n =locations.length;
        dp = new int[n][fuel + 1];
        for(int[] t : dp){
            Arrays.fill(t, -1);
        }
        int ans = dfs(locations, start, finish, fuel);
        Arrays.stream(dp).forEach(o-> System.out.println(Arrays.toString(o)));
        return ans;
    }

    private static int dfs(int[] locations, int pos, int finish, int fuel) {
        if(dp[pos][fuel] != -1){
            return dp[pos][fuel];
        }

        dp[pos][fuel] = 0;
        if (Math.abs(locations[pos] - locations[finish]) > fuel) {
            return 0;
        }

        int n = locations.length;
        for(int i = 0; i < n; i++){
            if(pos != i){
                int cost = Math.abs(locations[pos] - locations[i]);
                if(cost <= fuel){
                    dp[pos][fuel] += dfs(locations, i, finish, fuel - cost);
                    dp[pos][fuel] %= MOD;
                }
            }
        }

        if(pos == finish){
            dp[pos][fuel] += 1;
            dp[pos][fuel] %= MOD;
        }

        return dp[pos][fuel];
    }
}















