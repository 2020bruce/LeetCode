package com.zk.leetcode.深度优先搜索;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _743_网络延迟时间 {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        int time = networkDelayTime(times, n, k);
        System.out.println(time);
    }
    private static int[][] graph;
    public static int networkDelayTime(int[][] times, int n, int k) {
        graph = new int[n + 1][n + 1];
        for(int[] node : graph){
            Arrays.fill(node, 100000);
        }
        for(int[] time : times){
            int from = time[0], to = time[1], value = time[2];
            graph[from][to] = value;
        }
        for(int[] node : graph){
            System.out.println(Arrays.toString(node));
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, 100000);
        distance[k] = 0;

        boolean[] used = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        while(!queue.isEmpty()){
            int t = queue.poll();
            int min = 0;
            for(int i = 1; i <= n; i++){
                if(!used[i] && distance[t] + graph[t][i] < distance[i]){
                    distance[i] = distance[t] + graph[t][i];
                }
                if(!used[i] && distance[min] > distance[i]){
                    min = i;
                }
            }
            if(min != 0){
                queue.offer(min);
                used[min] = true;
            }
        }

        System.out.println(Arrays.toString(distance));

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < distance.length; i++){
            ans = Math.max(distance[i], ans);
        }
        return ans == 100000 ? -1 : ans;
    }
}
















