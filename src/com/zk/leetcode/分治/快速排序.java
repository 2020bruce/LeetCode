package com.zk.leetcode.分治;

import java.util.Arrays;

public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 7, -1, 5, 1, 8, 2, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int t = arr[low];
        int l = low;
        int r = high;
        while(l < r){
            while(l < r && arr[r] >= t){
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] < t){
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = t;
        quickSort(arr, low, l);
        quickSort(arr, l + 1, high);
    }
}
