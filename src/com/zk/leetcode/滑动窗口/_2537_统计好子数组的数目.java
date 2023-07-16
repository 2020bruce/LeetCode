package com.zk.leetcode.滑动窗口;

import java.util.HashMap;

public class _2537_统计好子数组的数目 {
    public static void main(String[] args) {
        int[] nums = {3,1,4,3,2,2,4};
        int k = 2;
        long countGood = countGood(nums, k);
        System.out.println(countGood);
    }
    public static long countGood(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // 存储各个数字的个数
        int cnt = 0; // 当前窗口数对数大于等于k的个数
        long ans = 0;
        int l = 0;
        for(int r = 0; r < n; r++){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            cnt += map.get(nums[r]) - 1;
            if(cnt >= k){
                cnt += 1 - map.get(nums[l]);
                map.put(nums[l], map.get(nums[l]) - 1);
                while(cnt >= k){
                    l++;
                    cnt += 1 - map.get(nums[l]);
                    map.put(nums[l], map.get(nums[l]) - 1);
                }
                map.put(nums[l], map.get(nums[l]) + 1);
                cnt += map.get(nums[l]) - 1;
                ans += l + 1;
            }
        }

        return ans;
    }

}
