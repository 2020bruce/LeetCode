package com.zk.leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_四数之和 {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        for(List<Integer> list : lists){
            list.forEach(o-> System.out.print(o + " "));
            System.out.println();
        }
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if(n < 4){
            return null;
        }

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < n - 3; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < n - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        lists.add(list);
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        right--;
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }

        return lists;
    }
}
