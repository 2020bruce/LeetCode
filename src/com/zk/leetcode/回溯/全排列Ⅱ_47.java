package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列Ⅱ_47 {
    static List<List<Integer>> lists = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static boolean[] isVisited;
    public static void main(String[] args) {
        int[] nums = {2,2,1,1};
        permuteUnique(nums);
        for(List<Integer> list : lists){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return lists;
    }
    private static void backtrack(int[] nums){
        if(list.size() == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!isVisited[i]){
                if(i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]){
                    continue;
                }
                list.add(nums[i]);
                isVisited[i] = true;
                backtrack(nums);
                list.remove(list.size() - 1);
                isVisited[i] = false;

            }
        }
    }
}
