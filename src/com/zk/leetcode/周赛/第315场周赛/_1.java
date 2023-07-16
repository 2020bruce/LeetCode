package com.zk.leetcode.周赛.第315场周赛;

import java.util.HashSet;
import java.util.Set;

public class _1 {
    public static void main(String[] args) {
        int[] nums = {-9,-43,24,-23,-16,-30,-38,-30};
        int maxK = findMaxK(nums);
        System.out.println(maxK);
    }
    public static int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int[] temp = new int[set.size()];
        int index = 0;
        for(int t : set){
            temp[index++] = t;
        }
        int n = temp.length;
        int[] allIn = new int[1001];
        int ans = -1;
        for(int i = 0; i < n; i++){
            if(temp[i] > 0){
                allIn[temp[i]]++;
            }else{
                allIn[-temp[i]]++;
            }
        }
        for(int i = allIn.length - 1; i > 0; i--){
            if(allIn[i] == 2){
                return i;
            }
        }
        return ans;
    }
}
