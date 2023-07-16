package com.zk.leetcode.记忆化搜索;

import java.util.Arrays;

public class _2328_网格图中递增路径的数目 {
    public static void main(String[] args) {
        int[][] grid = {
                {12469,18741,68716,30594,65029,44019,92944,84784,92781,5655,43120,81333,
                        54113,88220,23446,6129,2904,48677,20506,79604,82841,3938,46511,
                        60870,10825,31759,78612,19776,43160,86915,74498,38366,28228,23687,
                        40729,42613,61154,22726,51028,45603,53586,44657,97573,61067,27187,
                        4619,6135,24668,69634,24564,30255,51939,67573,87012,4106,76312,28737,7704,35798}
        };
        int paths = countPaths(grid);
        System.out.println(paths);
    }
    static int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int[][] dp;
    static final int MOD = 1000000007;
    public static int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans += dfs(grid, i, j);
                ans %= MOD;
            }
        }
        Arrays.stream(dp).forEach(o-> System.out.println(Arrays.toString(o)));

        return ans;
    }

    private static int dfs(int[][] grid, int row, int column) {
        int m = grid.length, n = grid[0].length;
        if(dp[row][column] != 0){
            return dp[row][column];
        }
        dp[row][column]++;
        for(int[] direction : directions){
            int x = direction[0] + row, y = direction[1] + column;
            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > grid[row][column]){
                dp[row][column] += dfs(grid, x, y);
                dp[row][column] %= MOD;
            }
        }

        return dp[row][column];
    }
}
