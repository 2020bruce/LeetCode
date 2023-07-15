package com.zk.leetcode.滑动窗口;

import java.util.Arrays;

public class _1477_找两个和为目标值且不重叠的子数组 {
    public static void main(String[] args) {
        int[] arr = {3,1,1,1,5,1,2,1};
        int target = 3;
        int minSum = minSumOfLengths(arr, target);
        System.out.println(minSum);
    }
    public static int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);

        int ans = Integer.MAX_VALUE;
        for(int l = 0, r = 0, sum = 0; r < n; r++){
            sum += arr[r];
            while(l <= r && sum > target){
                sum -= arr[l++];
            }
            if(sum == target){
                dp[r] = r - l + 1;
                if(l != 0){
                    ans = Math.min(ans, dp[l - 1] + r - l + 1);
                }
            }
            if(r != 0){
                dp[r] = Math.min(dp[r], dp[r - 1]);
            }
        }


        return ans > n ? -1 : ans;
    }
}
