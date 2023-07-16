package com.zk.leetcode.深度优先搜索;

public class _695_岛屿的最大面积 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int i = maxAreaOfIsland(grid);
        System.out.println(i);
    }
    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] != 0){
                    int num = dfs(grid, i, j);
                    res = Math.max(res, num);
                }
            }
        }
        return res;
    }
    static int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    private static int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int res = 1;
        for(int[] direction : directions){
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 0){
                res += dfs(grid, x, y);
            }
        }
        return res;
    }
}
























