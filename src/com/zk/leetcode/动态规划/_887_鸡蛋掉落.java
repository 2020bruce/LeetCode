package com.zk.leetcode.动态规划;

import java.util.HashMap;

public class _887_鸡蛋掉落 {
    public static void main(String[] args) {
        int k = 2, n = 6;
        int drop = superEggDrop(k, n);
        System.out.println(drop);
    }
    static HashMap<Integer, Integer> memo = new HashMap<>();
    
    public static int superEggDrop(int k, int n) {
        return dp(k, n);
    }

    private static int dp(int k, int n) {
        if(memo.containsKey(n * 100 + k)){
            return memo.get(n * 100 + k);
        }
        int ans = 0;
        if(n == 0){

        }else if(k == 1){
            ans = n;
        }else{
            int lo = 1, hi = n;
            while(lo < hi){
                int mid = (lo + hi) / 2;
                int up = dp(k, n - mid);
                int down = dp(k - 1, mid - 1);
                if(up > down){
                    lo = mid + 1;
                }else if(up < down){
                    hi = mid - 1;
                }else{
                    lo = hi = mid;
                }
            }
            ans = 1 + Math.min(Math.max(dp(k, n - lo), dp(k -  1, lo - 1)), Math.max(dp(k, n - hi), dp(k - 1, hi - 1)));
        }
        memo.put(n * 100 + k, ans);
        return memo.get(n * 100 + k);
    }
}




















