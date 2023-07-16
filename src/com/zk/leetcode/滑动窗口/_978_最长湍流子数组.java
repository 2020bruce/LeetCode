package com.zk.leetcode.滑动窗口;

public class _978_最长湍流子数组 {
    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        int size = maxTurbulenceSize(arr);
        System.out.println(size);
    }
    public static int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int left = 0, right = 0;
        int res = 0;
        while(right < n - 1){
            if(left == right){
                if(arr[left] == arr[left + 1]){
                    left++;
                }
                right++;
            }else{
                if(arr[right] > arr[right - 1] && arr[right] > arr[right + 1]){
                    right++;
                }else if(arr[right] < arr[right - 1] && arr[right] < arr[right + 1]){
                    right++;
                }else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
