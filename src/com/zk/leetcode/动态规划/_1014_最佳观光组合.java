package com.zk.leetcode.动态规划;

public class _1014_最佳观光组合 {
    public static void main(String[] args) {
        int[] values = {8,1,5,2,6};
        int i = maxScoreSightseeingPair(values);
        System.out.println(i);
    }
    public static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int res = 0;
        int left = values[0] + 0;
        for(int j = 1; j < n; j++){
            res = Math.max(res, left + values[j] - j);
            left = Math.max(left, values[j] + j);
        }

        return res;
    }
}
