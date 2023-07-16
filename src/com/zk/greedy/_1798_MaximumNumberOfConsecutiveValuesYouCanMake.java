package com.zk.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class _1798_MaximumNumberOfConsecutiveValuesYouCanMake {
    public static void main(String[] args) {
        int[] coins = {1,4,10,3,1}; //8
        int maximumConsecutive = getMaximumConsecutive(coins);
        System.out.println(maximumConsecutive);
    }
    public static int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        int ans = 1;
        for(int coin : coins){
            if(ans >= coin){
                ans += coin;
            }
        }


        return ans;
    }
}































