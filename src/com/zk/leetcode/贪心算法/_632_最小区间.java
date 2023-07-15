package com.zk.leetcode.贪心算法;

import java.util.*;

public class _632_最小区间 {
    public static void main(String[] args) {
        Integer[][] nums = {
//                {4,10,15,24,26},
//                {0,9,12,20},
//                {5,18,22,30}
                {1},{2},{3},{4},{5},{6},{7}
        };
        List<List<Integer>> lists = new ArrayList<>();

        for(Integer[] num : nums){
            List<Integer> list = new ArrayList<>(Arrays.asList(num));
            lists.add(list);
        }
        for(List<Integer> list : lists){
            list.forEach((item)-> System.out.print(item + " "));
            System.out.println();
        }

        int[] ints = smallestRange(lists);
        System.out.println(Arrays.toString(ints));

    }
    public static int[] smallestRange(List<List<Integer>> nums) {
        int minValue = Integer.MAX_VALUE;
        int[] ans = new int[2];
        int[] next = new int[nums.size()];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> nums.get(o).get(next[o])));
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            queue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }

        while(true){
            if(queue.isEmpty()){
                break;
            }
            int min = queue.poll();
            if(max - nums.get(min).get(next[min]) < minValue){
                minValue = max - nums.get(min).get(next[min]);
                ans[0] = nums.get(min).get(next[min]);
                ans[1] = max;
            }
            next[min]++;
            if(next[min] == nums.get(min).size()){
                break;
            }
            queue.add(min);
            max = Math.max(max, nums.get(min).get(next[min]));
        }

        return ans;
    }
}















