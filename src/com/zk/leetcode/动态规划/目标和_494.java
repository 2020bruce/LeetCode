package com.zk.leetcode.动态规划;

public class 目标和_494 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int i = findTargetSumWays(nums, target);
        System.out.println(i);
    }

    /**
     * 原问题等同于： 找到nums一个正子集和一个负子集，使得总和等于target
     *
     * 我们假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
     *
     * 那么让我们看看如何将其转换为子集求和问题：
     *
     *                   sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     * @param nums
     * @param target
     * @return
     */
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        sum += target;
        if(sum < 0 || sum % 2 != 0){
            return 0;
        }
        return subsetSum(nums, sum / 2);
    }
    private static int subsetSum(int[] nums, int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int i = n; i >= num; i--){
                dp[i] += dp[i - num];
            }
        }
        return dp[n];
    }
}
