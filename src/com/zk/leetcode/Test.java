package com.zk.leetcode;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int t  = 0; t < T; t++){
            String[] strs = sc.nextLine().split(" ");
            int n = strs.length;
            int[] nums = new int[n+1];
            for(int i = 1; i < n+1; i++){
                nums[i] = Integer.parseInt(strs[i-1]);
            }
            boolean[] flag  = new boolean[1];
            func(nums, 1, flag);
            System.out.println(flag[0] ? "Yes" : "No"  );
        }
    }


    public static int func(int[] nums, int index, boolean[] flag){
        if(index >= nums.length) return 0;

        int leftSum = 0;
        if(index*2 < nums.length){
            leftSum = func(nums, index*2, flag);
        }

        int rightSum = 0;
        if(index*2+1 < nums.length){
            rightSum = func(nums,index*2+1, flag);
        }

        if(leftSum == rightSum && leftSum != 0){
            flag[0] = true;
        }
        return leftSum + rightSum + nums[index];
    }
}