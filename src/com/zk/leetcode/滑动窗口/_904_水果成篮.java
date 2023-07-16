package com.zk.leetcode.滑动窗口;

import java.util.HashMap;

public class _904_水果成篮 {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        int i = totalFruit(fruits);
        System.out.println(i);
    }
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        if(n <= 2){
            return n;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        for(int right = 0; right < n; right++){
            int temp = fruits[right];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            while(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);

        }
        return res;
    }
}



















