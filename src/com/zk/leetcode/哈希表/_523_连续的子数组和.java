package com.zk.leetcode.哈希表;

import java.util.HashMap;

public class _523_连续的子数组和 {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        boolean b = checkSubarraySum(nums, k);
        System.out.println(b);
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n < 2){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int remainder = 0;
        for(int i = 0; i < n; i++){
            remainder = (remainder + nums[i]) % k;
            if(map.containsKey(remainder)){
                int preIndex = map.get(remainder);
                if(i - preIndex >= 2){
                    return true;
                }
            }else{
                map.put(remainder, i);
            }
        }

        return false;
    }
}
