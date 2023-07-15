package com.zk.leetcode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大整除子集_368 {
    public static void main(String[] args) {
        int[] nums = {4, 8, 10, 240};
        List<Integer> list = largestDivisibleSubset(nums);
        for(Integer i : list){
            System.out.println(i + " ");
        }
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        if(n == 1){
            list.add(nums[0]);
            return list;
        }
        Arrays.sort(nums);
        int[] dp = new int[n];//表示以当前点为结束的最大整除子集长度
        int[] pre = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(pre, -1);


        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        pre[i] = j;
                    }

                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(pre));
        int max = 0;
        int index = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        while(index != -1){
            list.add(nums[index]);
            index = pre[index];
        }

        return list;
    }
}












