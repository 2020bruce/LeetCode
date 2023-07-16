package com.zk.leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = threeSum(nums);
        for(List<Integer> i : list){
            for (Integer j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums);

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < n - 2; i++){
            if(nums[i] > 0){
                return lists;
            }
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            int target = -nums[i];
            while(left < right){
                if(nums[left] + nums[right] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++; right--;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }

                }else if(nums[left] + nums[right] < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return lists;
    }
}
