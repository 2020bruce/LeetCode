package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _174_地下城游戏 {
    public static void main(String[] args) {
        int[][] dungeon = {
                {-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
        };
        int hp = calculateMinimumHP(dungeon);
        System.out.println(hp);
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;
        System.out.println();
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int t = dungeon[i][j];
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - t, 1);
            }
        }
        Arrays.stream(dp).forEach(o-> System.out.println(Arrays.toString(o)));
        return dp[0][0];
    }
}






































