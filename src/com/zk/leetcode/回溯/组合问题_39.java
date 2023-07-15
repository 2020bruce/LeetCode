package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class 组合问题_39 {
    static List<List<Integer>> list = new ArrayList<>();
    static List<Integer> l = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        combinationSum(candidates, target);
        for(List<Integer> i : list){
            for(Integer in : i){
                System.out.print(in + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, 0);
        return list;
    }

    //更好的版本
    public static void backtrackBest(int[] candidates, int target, int begin){


        if(0 == target){
            list.add(new ArrayList<>(l));
            return;
        }
        int n = candidates.length;
        for(int i = begin; i < n; i++){
            if (candidates[i] <= target) {
                l.add(candidates[i]);
                backtrackBest(candidates, target - candidates[i], i);
                l.remove(l.size() - 1);
            }
        }

    }

    //自己版本
    public static void backtrack(int[] candidates, int target, int begin, int sum){

        if(sum == target){
            list.add(new ArrayList<>(l));
            return;
        }else if(sum > target){
            return;
        }
        int n = candidates.length;
        for(int i = begin; i < n; i++){

            l.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, target, i, sum);
            l.remove(l.size() - 1);
            sum -= candidates[i];
        }


    }
}

















