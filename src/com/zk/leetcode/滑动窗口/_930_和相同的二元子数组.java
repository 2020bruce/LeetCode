package com.zk.leetcode.滑动窗口;

import java.util.Arrays;
import java.util.HashMap;

public class _930_和相同的二元子数组 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        int i = numSubarraysWithSumOtherMethod(nums, goal);
        System.out.println(i);
    }



    //前缀和+哈希表
    public static int numSubarraysWithSumOtherMethod(int[] nums, int goal){
        int n = nums.length;
        int res = 0;
        if(n == 1) return goal == nums[0] ? 1 : res;
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++){
            pre[i + 1] = pre[i] + nums[i];
        }
        System.out.println(Arrays.toString(pre));
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < n; i++){
            int t = pre[i + 1] - goal;
            if(map.containsKey(t)){
                res += map.get(t);
            }
            map.put(pre[i + 1], map.getOrDefault(pre[i + 1], 0) + 1);
        }
        return res;
    }


    //滑动窗口
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int l1 = 0, l2 = 0, r = 0;// l1表示0的最左边位置，l2表示最右边0的右边一个位置
        int s1 = 0, s2 = 0;
        int res = 0;
        for(int num : nums){
            s1 += num;
            s2 += num;
            while(l1 <= r && s1 > goal){
                s1 -= nums[l1];
                l1++;
            }
            while(l2 <= r && s2 >= goal){
                s2 -= nums[l2];
                l2++;
            }
            res += l2 - l1;
            r++;
        }
        return res;
    }

}
