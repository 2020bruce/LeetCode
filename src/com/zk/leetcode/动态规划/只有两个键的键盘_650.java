package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class 只有两个键的键盘_650 {
    public static void main(String[] args) {
        int n = 1000;
        int minSteps = minStepsBest(n);
        System.out.println(minSteps);
    }

    public static int minStepsBest(int n){
        int ans = 0;
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                n /= i;
                ans += i;
            }
        }
        if (n > 1) {
            ans += n;
        }
        return ans;
    }

    public static int minSteps(int n) {
        if(n == 1){
            return 0;
        }
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++){
            if(i % 2 == 0){
                dp[i] = dp[i / 2] + 2;
            }else{
                for(int j = (i - 1) / 2; j >= 1; j--){
                    if(i % j == 0){
                        dp[i] = dp[j] + i / j;
                        break;
                    }
                }
            }

        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
