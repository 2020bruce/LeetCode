package com.zk.leetcode.回溯;

public class _1219_黄金矿工 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,6,20,0},
                {0,0,3,0,0},
                {16,9,16,8,0},
                {14,0,4,20,9}
        };
        int maximumGold = getMaximumGold(grid);
        System.out.println(maximumGold);
    }

    static int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int maximumGold = 0;
    public static int getMaximumGold(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                backtrack(grid, new int[]{i, j}, 0);
            }
        }

        return maximumGold;
    }

    private static void backtrack(int[][] grid, int[] begin, int val) {
        int x = begin[0];
        int y = begin[1];
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0){
            return;
        }
        int newVal = val + grid[x][y];
        int temp = grid[x][y];
        maximumGold = Math.max(maximumGold, newVal);
        grid[x][y] = 0;
        for(int k = 0; k < direction.length; k++){
            int newX = x + direction[k][0];
            int newY = y + direction[k][1];
            backtrack(grid, new int[]{newX, newY}, newVal);

        }
        grid[x][y] = temp;

    }
}























