package com.zk.leetcode.动态规划;

public class _403_青蛙过河 {
    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        boolean canCross = canCross(stones);
        System.out.println(canCross);
    }
    public static boolean canCross(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        for(int i = 1; i < n; i++){
            if(stones[i] - stones[i - 1] > i){
                return false;
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                int k = stones[i] - stones[j];
                if(k > j + 1){
                    break;
                }
                dp[i][k] = dp[j][k] || dp[j][k - 1] || dp[j][k + 1];
            }
        }
        boolean ans = false;
        for(int i = 0; i < n; i++){
            if(dp[n - 1][i]){
                ans = true;
                break;
            }
        }


        return ans;
    }
}




























