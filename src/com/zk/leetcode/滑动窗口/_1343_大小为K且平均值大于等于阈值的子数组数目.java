package com.zk.leetcode.滑动窗口;

public class _1343_大小为K且平均值大于等于阈值的子数组数目 {
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3, threshold = 4;
        int i = numOfSubarrays(arr, k, threshold);
        System.out.println(i);
    }
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        for(int i = 1; i < n; i++){
            arr[i] += arr[i - 1];
        }
        int res = 0;
        if(arr[k - 1] / k >= threshold){
            res++;
        }
        for(int i = k; i < n; i++){
            if((arr[i] - arr[i - k]) / k >= threshold){
                res++;
            }
        }
        return res;
    }
}



















