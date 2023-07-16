package com.zk.leetcode.优先队列;

import java.util.PriorityQueue;

public class _295_数据流的中位数 {
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(-1);
        System.out.println(finder.findMedian());
        finder.addNum(-2);
        System.out.println(finder.findMedian());
        finder.addNum(-3);
        System.out.println(finder.findMedian());
        finder.addNum(-4);
        System.out.println(finder.findMedian());
        finder.addNum(-5);
        System.out.println(finder.findMedian());

    }
}

/*
输入
["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
输出
[null,null,-1.0,null,-1.5,null,-2.0,null,-2.5,null,-3.0]
 */
class MedianFinder {
    PriorityQueue<Integer> minQueue;
    PriorityQueue<Integer> maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
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

    public double findMedian() {
        if(minQueue.size() < maxQueue.size()){
            return maxQueue.peek();
        }else{
            return (double)(minQueue.peek() + maxQueue.peek()) / 2;
        }
    }
}

