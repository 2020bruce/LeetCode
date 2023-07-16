package com.zk.leetcode.滑动窗口;

import java.util.HashSet;

public class _1695_删除子数组的最大得分 {
    public static void main(String[] args) {
        int[] nums = {4,2,4,5,6};
        int i = maximumUniqueSubarray(nums);
        System.out.println(i);
    }
    public static int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int l = 0, r = 0;
        int ans = 0;
        int temp = 0;
        while(r < nums.length){
            if(hashSet.contains(nums[r])){
                temp -= nums[l];
                hashSet.remove(nums[l++]);
            }else{
                hashSet.add(nums[r]);
                temp += nums[r];
                ans = Math.max(ans, temp);
                r++;
            }

        }

        return ans;
    }
}




























