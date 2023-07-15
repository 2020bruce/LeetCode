package com.zk.leetcode.贪心算法;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class _826_安排工作以达到最大收益 {
    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10}, profit = {10,20,30,40,50}, worker = {4,5,6,7};
        int i = maxProfitAssignment(difficulty, profit, worker);
        System.out.println(i);
    }
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map.Entry<Integer, Integer>[] pair = new Map.Entry[difficulty.length];
        for(int i = 0; i < difficulty.length; i++){
            pair[i] = new AbstractMap.SimpleEntry<>(difficulty[i], profit[i]);
        }
        Arrays.sort(pair, Comparator.comparingInt(Map.Entry::getKey));
        Arrays.sort(worker);
        int i = 0, res = 0, max = 0;
        for(int skill : worker){
            while(i < difficulty.length && skill >= pair[i].getKey()){
                max = Math.max(max, pair[i].getValue());
                i++;
            }
            res += max;
        }
        return res;
    }
}
