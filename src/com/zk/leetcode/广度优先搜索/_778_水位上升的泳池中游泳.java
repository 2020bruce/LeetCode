package com.zk.leetcode.广度优先搜索;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _778_水位上升的泳池中游泳 {
    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 2, 3, 4},
                {24,23,22,21, 5},
                {12,13,14,15,16},
                {11,17,18,19,20},
                {10, 9, 8, 7, 6}
        };
        int swimInWater = swimInWater(grid);
        System.out.println(swimInWater);
    }
    static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] distTo = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> grid[o[0]][o[1]]));
        minHeap.offer(new int[]{0, 0});

        for(int[] arr : distTo){
            Arrays.fill(arr, n * n);
        }
        distTo[0][0] = grid[0][0];

        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int curX = cur[0], curY = cur[1];

            if(isVisited[curX][curY]){
                continue;
            }

            isVisited[curX][curY] = true;
            if(curX == n - 1 && curY == n - 1){
                for(int[] dist : distTo){
                    System.out.println(Arrays.toString(dist));
                }
                return distTo[n - 1][n - 1];
            }

            for(int[] direction : directions){
                int x = direction[0], y = direction[1];
                int newX = curX + x, newY = curY + y;
                if(newX >= 0 && newX < n && newY >= 0 && newY < n && !isVisited[newX][newY]){
                    distTo[newX][newY] = Math.max(distTo[curX][curY], grid[newX][newY]);
                    minHeap.offer(new int[]{newX, newY});
                }
            }
        }
        for(int[] dist : distTo){
            System.out.println(Arrays.toString(dist));
        }

        return -1;
    }
}

































