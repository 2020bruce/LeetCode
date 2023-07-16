package com.zk.leetcode.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _398_随机数索引 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        _398_随机数索引 v = new _398_随机数索引(nums);
        int i = v.pick(3);
        System.out.println(i);

    }
    int[] nums;
    HashMap<Integer, List<Integer>> hash = new HashMap<>();
    public _398_随机数索引(int[] nums) {
        this.nums = nums;
        for(int i = 0; i < nums.length; i++){
            hash.putIfAbsent(nums[i], new ArrayList<>());
            hash.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> index = hash.get(target);
        int random = (int)(Math.random() * index.size());
        return index.get(random);
    }
}













