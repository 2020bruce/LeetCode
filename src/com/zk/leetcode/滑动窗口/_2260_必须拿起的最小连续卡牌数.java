package com.zk.leetcode.滑动窗口;

import java.util.HashMap;

public class _2260_必须拿起的最小连续卡牌数 {
    public static void main(String[] args) {
        int[] cards = {1,3,4,5,2,6,2,5};
        int pickup = minimumCardPickup(cards);
        System.out.println(pickup);
    }

    public static int minimumCardPickup(int[] cards) {
        int n = cards.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int l = 0;
        for(int r = 0; r < n; r++){
            int rCard = cards[r];
            hashMap.put(rCard, hashMap.getOrDefault(rCard, 0) + 1);

            if(hashMap.get(rCard) >= 2){
                while(cards[l] != rCard){
                    hashMap.put(cards[l], hashMap.get(cards[l]) - 1);
                    l++;
                }
                ans = Math.min(ans, r - l + 1);
                hashMap.put(cards[l], hashMap.get(cards[l]) - 1);
                l++;
            }

        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
