package com.zk.leetcode.周赛.第315场周赛;

import java.util.HashSet;
import java.util.Set;

public class _2 {
    public static void main(String[] args) {
        int[] nums = {1,13,10,12,31};
        int i = countDistinctIntegers(nums);
        System.out.println(i);
    }
    public static int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n * 2];

        for(int i = 0; i < n; i++){
            temp[i] = nums[i];
        }
        for(int i = 0; i < n; i++){
            String s = "";
            String reverse = "";
            s = nums[i] + "";
            int m = s.length();
            for(int k = 1; k <= m; k++){
                reverse += Integer.valueOf((int) (nums[i] % (Math.pow(10, k)) / (Math.pow(10, k - 1))));
            }
            System.out.println(reverse);
            temp[i + n] = Integer.valueOf(reverse);

        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < temp.length; i++){
            set.add(temp[i]);
        }
        return set.size();
    }
}
