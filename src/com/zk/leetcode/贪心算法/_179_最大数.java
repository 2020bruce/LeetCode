package com.zk.leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class _179_最大数 {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String s = largestNumber(nums);
        System.out.println(s);
    }
    public static String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s2 + s1).compareTo(s1 + s2);

            }
        });
        if(arr[0] == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i);
        }
        return sb.toString();
    }
}












