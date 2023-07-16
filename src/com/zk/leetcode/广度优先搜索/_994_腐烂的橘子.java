package com.zk.leetcode.广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

public class _994_腐烂的橘子 {
    public static void main(String[] args) {
        //int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid = {{0, 1}};
        int i = orangesRotting(grid);
        System.out.println(i);
    }
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minTime = Integer.MAX_VALUE;
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Integer[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }
        minTime = bfs(grid, queue, isVisited);
        return minTime;
    }

    private static Integer bfs(int[][] grid, Queue<Integer[]> queue, boolean[][] isVisited) {
        int m = grid.length, n = grid[0].length;
        int time = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            for(int i = 0; i < size; i++){
                Integer[] orange = queue.poll();
                int x = orange[0], y = orange[1];
                for(int k = 0; k < direction.length; k++){
                    int newX = direction[k][0] + x, newY = direction[k][1] + y;
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n){
                        if(!isVisited[newX][newY] && grid[newX][newY] == 1){
                            queue.offer(new Integer[]{newX, newY});
                            isVisited[newX][newY] = true;
                        }
                    }
                }
            }

        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!isVisited[i][j] && grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time == -1 ? 0 : time;
    }
}





































