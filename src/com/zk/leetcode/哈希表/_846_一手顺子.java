package com.zk.leetcode.哈希表;

import java.util.Arrays;
import java.util.HashMap;

public class _846_一手顺子 {
    public static void main(String[] args) {
        int[] hand = {2,1,2,4,1,3,3,3};
        int groupSize = 2;
        boolean b = isNStraightHand(hand, groupSize);
        System.out.println(b);
    }
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t : hand){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        Arrays.sort(hand);
        for(int i = 0; i < n - groupSize + 1; i++){
            if(map.get(hand[i]) > 0){
                for(int j = 0; j < groupSize; j++){
                    int t = hand[i] + j;
                    if(map.containsKey(t) && map.get(t) > 0){
                        map.put(t, map.get(t) - 1);
                    }else{
                        return false;
                    }
                }
            }else if(map.get(hand[i]) < 0){
                return false;
            }
        }
        System.out.println(Arrays.toString(hand));

        return true;
    }
}
