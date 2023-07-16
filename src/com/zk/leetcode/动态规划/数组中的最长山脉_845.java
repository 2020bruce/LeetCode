package com.zk.leetcode.动态规划;

public class 数组中的最长山脉_845 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,4,3,2,1,0};
        int i = longestMountain(arr);
        System.out.println(i);
    }
    public static int longestMountain(int[] arr) {
        int n = arr.length;
        if(n < 3){
            return 0;
        }
        int i = 0;
        i = getFirstIndex(arr, i, n);
        int res = 0;
        int left;
        int right;
        while(true){
            left = 1;
            right = 0;
            while(i < n - 1 && arr[i + 1] > arr[i]){
                i++;
                left++;
            }
            if(i == n - 1){
                break;
            }
            if(arr[i + 1] == arr[i]){
                i = getFirstIndex(arr, i, n);
                continue;
            }
            while(i < n - 1 && arr[i + 1] < arr[i]){
                i++;
                right++;
            }
            res = Math.max(res, left + right);
        }
        return res;
    }
    private static int getFirstIndex(int[] arr, int index, int n) {
        while(index < n - 1 && arr[index] >= arr[index + 1]){
            index++;
        }
        return index;
    }
}










