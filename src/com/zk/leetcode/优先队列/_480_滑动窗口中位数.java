package com.zk.leetcode.优先队列;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _480_滑动窗口中位数 {
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,
                2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 3;
        double[] window = medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(window));
    }
    static PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];
        int index = 0;
        for(int i = 0; i < k; i++){
            addNum(nums[i]);
        }
        ans[index++] = findMedian();
        for(int i = k; i < n; i++){
            addNum(nums[i]);
            deleteNum(nums[i - k]);
            ans[index++] = findMedian();
        }

        return ans;
    }

    public static void deleteNum(int num){
        if(maxQueue.contains(num) && num <= maxQueue.peek()){
            maxQueue.remove(num);
            if(maxQueue.size() < minQueue.size()){
                maxQueue.offer(minQueue.poll());
            }
        }else{
            minQueue.remove(num);
            if(maxQueue.size() - 1 > minQueue.size()){
                minQueue.offer(maxQueue.poll());
            }
        }

    }

    public static void addNum(int num) {
        if(maxQueue.isEmpty() || num <= maxQueue.peek()){
            maxQueue.add(num);
            if(minQueue.size() < maxQueue.size() - 1){
                minQueue.offer(maxQueue.poll());
            }
        }else{
            minQueue.add(num);
            if (minQueue.size() > maxQueue.size()){
                maxQueue.add(minQueue.poll());
            }
        }
    }

    public static double findMedian() {
        if(minQueue.size() < maxQueue.size()){
            return maxQueue.peek();
        }else{
            return (double)minQueue.peek() / 2 + (double)maxQueue.peek() / 2;
        }
    }
}


















