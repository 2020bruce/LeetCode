package com.zk.leetcode.深度优先搜索;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _934_最短的桥 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}
        };
        int i = shortestBridge(grid);
        for(int[] arr : grid){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(i);
    }
    static int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public static int shortestBridge(int[][] grid) {
        int res = 0;
        boolean flag = false;
        Queue<Integer[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] != 0 && !flag){
                    dfs(grid, i, j);
                    flag = true;
                }
                if(grid[i][j] == 1){
                    queue.offer(new Integer[]{i, j});
                }
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Integer[] position = queue.poll();
                grid[position[0]][position[1]] = 3;
                for(int[] direction : directions){
                    int x = position[0] + direction[0];
                    int y = position[1] + direction[1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                        if(grid[x][y] == 0){
                            queue.offer(new Integer[]{x, y});
                            grid[x][y] = 3;
                        }else if(grid[x][y] == 2){
                            return res;
                        }

                    }
                }
            }
            res++;
        }
        return res;
    }
    private static void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 2;
        for(int[] direction : directions){
            int x = i + direction[0];
            int y = j + direction[1];
            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                dfs(grid, x, y);
            }
        }
    }
}




















