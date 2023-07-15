package com.zk.leetcode.滑动窗口;

import java.util.Arrays;

public class _1423_可获得的最大点数 {
    public static void main(String[] args) {
        int[] cardPoints = {1,1000,1};
        int k = 1;
        int i = maxScore(cardPoints, k);
        System.out.println(i);
    }
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + cardPoints[i - 1];
        }
        System.out.println(Arrays.toString(cardPoints));
        System.out.println(Arrays.toString(preSum));
        int ans = preSum[k];
        for(int i = n - k; i <= n; i++){
            ans = Math.max(preSum[n] - preSum[i] + preSum[k - (n - i)], ans);
        }

        return ans;
    }
}
