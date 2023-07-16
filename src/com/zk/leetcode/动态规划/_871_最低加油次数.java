package com.zk.leetcode.动态规划;

import java.util.PriorityQueue;

public class _871_最低加油次数 {
    public static void main(String[] args) {
        int target = 100, startFuel = 25;
        int[][] stations = {{25,25},{50,25},{75,25}};
        int stops = minRefuelStopsBetter(target, startFuel, stations);
        System.out.println(stops);
    }

    //贪心
    public static int minRefuelStopsBetter(int target, int startFuel, int[][] stations){
        int n = stations.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int fuel = startFuel, prev = 0;
        int ans = 0;
        for(int i = 0; i <= n; i++){
            int curr = i < n ? stations[i][0] : target;
            fuel -= curr - prev;
            while(fuel < 0 && !queue.isEmpty()){
                fuel += queue.poll();
                ans++;
            }
            if(fuel < 0){
                return -1;
            }
            if(i < n){
                queue.offer(stations[i][1]);
                prev = curr;
            }
        }

        return ans;
    }


    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int[] dp = new int[n + 1]; // 加第i次油可走的最大距离
        dp[0] = startFuel;

        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(dp[j] >= stations[i][0]){
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }

        }

        for(int i = 0; i <= n; i++){
            if(dp[i] >= target){
                return i;
            }
        }
        return -1;
    }
}
