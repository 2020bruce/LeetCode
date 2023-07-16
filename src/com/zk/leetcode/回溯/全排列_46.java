package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class 全排列_46 {
    static List<List<Integer>> lists = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        permute(nums);
        for(List<Integer> list : lists){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return lists;
    }
    private static void backtrack(int[] nums){
        if(list.size() == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                backtrack(nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
