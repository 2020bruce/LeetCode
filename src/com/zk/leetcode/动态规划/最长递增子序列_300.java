package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 最长递增子序列_300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int i = lengthOfLISBest(nums);
        System.out.println(i);
    }

    public static int lengthOfLISBest(int[] nums){
        int n = nums.length;
        int[] tailMIn = new int[n];//tailMin数组表示nums中以i下标结尾的最小值
        tailMIn[0] = nums[0];
        int len = 0;
        for(int i = 1; i < n; i++){
            if(nums[i] > tailMIn[len]){
                tailMIn[++len] = nums[i];
            }else{
                int l = 0, r = len, pos = -1;
                while(l <= r){//二分法，会找到nums【i】刚好大于tailMin【len】中的位置
                    int mid = (l + r) / 2;
                    if(tailMIn[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
                tailMIn[pos + 1] = nums[i];
            }
        }
        return len + 1;
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
