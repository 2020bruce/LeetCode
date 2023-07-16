package com.zk.leetcode.哈希表;

import java.util.HashMap;

public class _974_和可被K整除的子数组 {
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        int i = subarraysDivByK(nums, k);
        System.out.println(i);
    }
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for(int i = 0; i < n; i++){
            // 余数在数学中不能为负数
            sum = (((sum + nums[i]) % k) + k) % k;
            if(map.containsKey(sum)){
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
