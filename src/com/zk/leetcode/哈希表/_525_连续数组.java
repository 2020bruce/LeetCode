package com.zk.leetcode.哈希表;

import java.util.HashMap;

public class _525_连续数组 {
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        int length = findMaxLength(nums);
        System.out.println(length);
    }
    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(count, -1);
        for(int i = 0; i < n; i++){
            int t = nums[i];
            if(t == 1){
                count++;
            }else{
                count--;
            }
            if(map.containsKey(count)){
                maxLength = Math.max(maxLength, i - map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
















































