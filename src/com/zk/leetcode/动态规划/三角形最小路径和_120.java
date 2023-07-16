package com.zk.leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

public class 三角形最小路径和_120 {
    public static void main(String[] args) {
        List<List<Integer>> list= new ArrayList<>(4);
        for(int i = 0; i < 4; i++){
            List<Integer> l = new ArrayList<Integer>(i +1);
            list.add(l);
        }
        list.get(0).add(2);
        list.get(1).add(3);
        list.get(1).add(4);
        list.get(2).add(6);
        list.get(2).add(5);
        list.get(2).add(7);
        list.get(3).add(4);
        list.get(3).add(1);
        list.get(3).add(8);
        list.get(3).add(3);
        int i = minimumTotal(list);
        System.out.println(i);

    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int len = triangle.size();
        int[][] dp = new int[len][len];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < len; i++){
            for(int j = 0; j < i + 1; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }else if(j == triangle.get(i).size() - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }

            }
        }

        int minTotal = dp[len - 1][0];
        for (int i = 1; i < len; ++i) {
            minTotal = Math.min(minTotal, dp[len - 1][i]);
        }
        return minTotal;
    }
}
