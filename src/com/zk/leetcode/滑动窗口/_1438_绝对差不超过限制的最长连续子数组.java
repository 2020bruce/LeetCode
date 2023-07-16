package com.zk.leetcode.滑动窗口;

import java.util.PriorityQueue;

public class _1438_绝对差不超过限制的最长连续子数组 {
    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int limit = 4;
        int i = longestSubarray(nums, limit);
        System.out.println(i);
    }
    public static int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));


        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < nums.length && left < nums.length) {
            minQueue.add(nums[right]);
            maxQueue.add(nums[right]);

            if(maxQueue.peek() - minQueue.peek() <= limit){
                ans = Math.max(ans, right - left + 1);
                right++;
                continue;
            }

            minQueue.remove(nums[left]);
            maxQueue.remove(nums[left]);

            left++;
            right++;

        }
        return ans;



    }
}
