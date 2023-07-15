package com.zk.leetcode.广度优先搜索;

import java.util.*;

public class _815_公交路线 {
    public static void main(String[] args) {
        int[][] routes = {{1,2,7},{3,6,7}};
        int source = 1, target = 6;
        int i = numBusesToDestination(routes, source, target);
        System.out.println(i);
    }

    /**
     * 1.定义每个车站会有那几辆公交车经过(使用Map<Integer, List<Integer>定义)，以及各个公交车之间是否互通（使用boolean[][]定义）；
     * 2.从source车站开始，对于公交车进行广度优先遍历，定义从source开始的车辆到其他车辆的距离（使用int[]定义）；
     * 3.获得经过target车站的所有车辆，取经过source车辆到经过target车辆的最小乘坐车辆数。
     * @param routes
     * @param source
     * @param target
     * @return
     */
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int n = routes.length;
        boolean[][] busedConnect = new boolean[n][n];
        Map<Integer, List<Integer>> busesPassByTheStation = new HashMap<>(); // key表示车站，value表示该车站会经过哪几辆公交车
        for(int i = 0; i < n; i++){
            for(int station : routes[i]){
                List<Integer> buses = busesPassByTheStation.getOrDefault(station, new ArrayList<>());
                for(int bus : buses){
                    busedConnect[i][bus] = busedConnect[bus][i] = true;
                }
                buses.add(i);
                busesPassByTheStation.put(station, buses);
            }
        }
        int[] dis = new int[n];
        Queue<Integer> queue = new ArrayDeque<>();
        Arrays.fill(dis, -1);
        for(int bus : busesPassByTheStation.getOrDefault(source, new ArrayList<>())){
            dis[bus] = 1;
            queue.offer(bus);
        }
        while(!queue.isEmpty()){
            int from = queue.poll();
            for(int j = 0; j < n; j++){
                if(busedConnect[from][j] && dis[j] == -1){
                    dis[j] = dis[from] + 1;
                    queue.offer(j);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        List<Integer> targetBuses = busesPassByTheStation.getOrDefault(target, new ArrayList<>());
        for(int buses : targetBuses){
            if(dis[buses] != -1){
                res = Math.min(res, dis[buses]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}




























