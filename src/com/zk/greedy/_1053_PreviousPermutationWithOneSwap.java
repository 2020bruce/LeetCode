package com.zk.greedy;

import java.util.Arrays;

public class _1053_PreviousPermutationWithOneSwap {
    public static void main(String[] args) {
        int[] arr = {1,9,4,6,7};
        int[] opt1 = prevPermOpt1(arr);
        System.out.println(Arrays.toString(opt1));
    }

    /**
     * 交换的两个数：左边的数大于右边的数
     * 左边的数靠右
     * 右边的值为左边的数右边的最大数
     *
     * @param arr
     * @return
     */
    public static int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int left, right = -1;
        for(int i = n - 1; i >= 0; i--){
            int max = Integer.MIN_VALUE;
            left = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[i] && max < arr[j]){
                    max = arr[j];
                    right = j;
                }
            }
            if(right != -1){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                break;
            }

        }
        return arr;
    }
}

























