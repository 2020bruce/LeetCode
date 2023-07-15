package com.zk.leetcode.滑动窗口;

import java.util.Arrays;
import java.util.LinkedList;

public class _239_滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        //            [0, 1, 2, 3, 4, 5, 6, 7]
        int k = 3;
        int[] ints = maxSlidingWindowBetter(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindowBetter(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < k; i++){
            while(!list.isEmpty() && nums[list.peekFirst()] <= nums[i]){
                list.pollFirst();
            }
            list.addFirst(i);
        }
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[list.peekLast()];
        for(int i = k; i < nums.length; i++){
            while(!list.isEmpty() && list.peekLast() <= (i - k)){
                list.pollLast();
            }
            while(!list.isEmpty() && nums[list.peekFirst()] <= nums[i]){
                list.pollFirst();
            }
            list.addFirst(i);
            ans[i - k + 1] = nums[list.peekLast()];
        }
        return ans;
    }

//    超时
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        TreeMap<Integer, Integer> map = new TreeMap<>(((o1, o2) -> o2 - o1));
//        for(int i = 0; i < k - 1; i++){
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        int[] ans = new int[nums.length - k + 1];
//        for(int i = k - 1; i < nums.length; i++){
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//            ans[i - k + 1] = map.keySet().stream().filter((o)->map.get(o)!=0).findFirst().get();
//            map.put(nums[i - k + 1], map.get(nums[i - k + 1]) - 1);
//        }
//
//        return ans;
//    }
}
