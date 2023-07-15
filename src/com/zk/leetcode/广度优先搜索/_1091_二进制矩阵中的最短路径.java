package com.zk.leetcode.广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

public class _1091_二进制矩阵中的最短路径 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        int i = shortestPathBinaryMatrix(grid);
        System.out.println(i);
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0){
            return -1;
        }
        int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        int res = -1;
        int level = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{0, 0});
        grid[0][0] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int k = 0; k < size; k++){
                Integer[] cur = queue.poll();
                for(int d = 0; d < direction.length; d++){
                    int i = cur[0] + direction[d][0];
                    int j = cur[1] + direction[d][1];
                    if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0){
                        queue.offer(new Integer[]{i, j});
                        grid[i][j] = 1;
                    }
                }
                if(cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1){
                    res = level;
                }
            }

        }
        return res;
    }
}
