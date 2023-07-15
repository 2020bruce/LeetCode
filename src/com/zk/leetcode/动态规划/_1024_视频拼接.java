package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _1024_视频拼接 {
    public static void main(String[] args) {
        int[][] clips = {{0, 4}, {2, 8}};
        int time = 5;
        int i = videoStitching(clips, time);
        System.out.println(i);
    }
    public static int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for(int i = 1; i <= time; i++){
            for(int[] clip : clips){
                if(i > clip[0] && i <= clip[1]){
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE - 1 ? -1 : dp[time];
    }
}

































































