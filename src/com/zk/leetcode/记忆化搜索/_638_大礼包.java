package com.zk.leetcode.记忆化搜索;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class _638_大礼包 {
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();
        Collections.addAll(price, 6,3,6,9,4,7);
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        Collections.addAll(first, 1,2,5,3,0,4,29);
        Collections.addAll(second, 3,1,3,0,2,2,19);
        Collections.addAll(special, first, second);
        Collections.addAll(needs, 4,1,5,2,2,4);
        int i = shoppingOffers(price, special, needs);
        System.out.println(i);

    }

    static HashMap<List<Integer>, Integer> hashMap = new HashMap<>();
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        List<List<Integer>> curSpecial = new ArrayList<>();
        for(List<Integer> s : special){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += s.get(i) * price.get(i);
            }
            if(sum > s.get(n)){
                curSpecial.add(s);
            }
        }
        return dfs(price, curSpecial, needs);
    }

    private static int dfs(List<Integer> price, List<List<Integer>> curSpecial, List<Integer> needs) {
        if(hashMap.get(needs) != null){
            return hashMap.get(needs);
        }
        int n = price.size();
        int minPrice = 0;
        for(int i = 0; i < n; i++){
            minPrice += needs.get(i) * price.get(i);
        }
        for(List<Integer> cur : curSpecial){
            int i = 0;
            for(; i < n; i++){
                if(cur.get(i) > needs.get(i)){
                    break;
                }
            }
            if(i != n){
                continue;
            }
            List<Integer> curNeeds = new ArrayList();
            for(int j = 0; j < n; j++){
                curNeeds.add(needs.get(j) - cur.get(j));
            }
            int min = dfs(price, curSpecial, curNeeds);
            minPrice = Math.min(minPrice, min + cur.get(n));
        }
        hashMap.put(needs, minPrice);
        return hashMap.get(needs);
    }
}
















