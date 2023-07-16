package com.zk.leetcode.滑动窗口;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _1696_跳跃游戏VI {
    public static void main(String[] args) {
        int[] nums = {1,-1,-2,4,-7,3};
        int k = 2;
        int maxResult = maxResultBest(nums, k);
        System.out.println(maxResult);
    }

    public static int maxResultBest(int[] nums, int k){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 1; i < n; i++){
            while(!deque.isEmpty() && dp[i - 1] >= dp[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i - 1);
            if(deque.peekFirst() < i - k){
                deque.pollFirst();
            }
            dp[i] = dp[deque.peekFirst()] + nums[i];
        }
        return dp[n - 1];
    }

    public static int maxResult(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            for(int j = Math.max(0, i - k); j < i; j++){
                dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += nums[i];
        }
        System.out.println(Arrays.toString(dp));

        return dp[n - 1];
    }
}
