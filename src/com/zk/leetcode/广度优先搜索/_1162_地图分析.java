package com.zk.leetcode.广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

public class _1162_地图分析 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        int maxDistance = maxDistance(grid);
        System.out.println(maxDistance);
    }


    public static int maxDistanceBetter(int[][] grid){
        int n = grid.length, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) continue;
                grid[i][j] = 201; //max
                if (i > 0) grid[i][j] = Math.min(grid[i][j], grid[i-1][j] + 1);
                if (j > 0) grid[i][j] = Math.min(grid[i][j], grid[i][j-1] + 1);
            }
        }

        for (int i = n-1; i > -1; i--) {
            for (int j = n-1; j > -1; j--) {
                if (grid[i][j] == 1) continue;
                if (i < n-1) grid[i][j] = Math.min(grid[i][j], grid[i+1][j] + 1);
                if (j < n-1) grid[i][j] = Math.min(grid[i][j], grid[i][j+1] + 1);
                res = Math.max(res, grid[i][j]); //update the maximum
            }
        }
        return res == 201 ? -1 : res - 1;
    }


    //超时
    static int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static int maxDistance(int[][] grid) {
        int n = grid.length;
        int max = -1;
        int i = 0, j = 0;
        while(i < n && j < n){
            if(grid[i][j] == 1){
                if(j >= n - 1){
                    i++;
                    j = 0;
                }else{
                    j++;
                }
                continue;
            }
            Queue<Integer[]> queue = new LinkedList<>();
            queue.offer(new Integer[]{i, j});
            int h = 0;
            boolean[][] isVisited = new boolean[n][n];
            isVisited[i][j] = true;
            go:
            while(queue.size() > 0){
                int size = queue.size();
                h++;
                for(int k = 0; k < size; k++){
                    Integer[] item = queue.poll();
                    for(int t = 0; t < direction.length; t++){
                        int x = item[0] + direction[t][0];
                        int y = item[1] + direction[t][1];
                        if(x >= 0 && x < n && y >= 0 && y < n && !isVisited[x][y]){
                            if(grid[x][y] == 1){
                                max = Math.max(max, h);
                                break go;
                            }else{
                                queue.offer(new Integer[]{x, y});
                                isVisited[x][y] = true;
                            }
                        }
                    }
                }
            }
            if(j >= n - 1){
                i++;
                j = 0;
            }else{
                j++;
            }


        }
        return max;
    }
}
