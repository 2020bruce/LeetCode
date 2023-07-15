package com.zk.leetcode.哈希表;

import java.util.HashMap;

public class _560_和为K的子数组 {
    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            pre += nums[i];
            if(map.containsKey(pre - k)){
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
