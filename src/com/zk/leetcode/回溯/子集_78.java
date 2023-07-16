package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集_78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for(List<Integer> list : subsets){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> lists = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return lists;
    }
    private static void backtrack(int[] nums, int begin){
        lists.add(new ArrayList<>(list));
        if(begin == nums.length){
            return;
        }
        for(int i = begin; i < nums.length; i++){
            list.add(nums[i]);
            backtrack(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
