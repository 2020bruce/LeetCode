package com.zk.leetcode.贪心算法;

import java.util.Arrays;

public class 数组拆分_561 {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0){
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }
    public int arrayPairSum(int[] nums) {

        return 0;
    }
}











