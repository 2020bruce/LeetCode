package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和Ⅱ_40 {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> l = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        combinationSum2(candidates, target);
        for(List<Integer> i : list){
            for(Integer in : i){
                System.out.print(in + " ");
            }
            System.out.println();
        }

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return list;
    }
    private static void backtrack(int[] candidates, int target, int begin){
        int n = candidates.length;
        if(target == 0){
            list.add(new ArrayList<>(l));
            return;
        }



        for(int i = begin; i < n; i++){
            if(candidates[i] <= target){

                //关键代码
                if(i > begin && candidates[i] == candidates[i - 1]){
                    continue;
                }

                l.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1);
                l.remove(l.size() - 1);
            }
        }
    }
}













