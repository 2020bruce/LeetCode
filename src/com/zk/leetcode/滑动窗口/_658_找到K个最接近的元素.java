package com.zk.leetcode.滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class _658_找到K个最接近的元素 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4, x = 3;
        List<Integer> list = findClosestElements(arr, k, x);
        list.forEach((i)-> System.out.print(i + "\t"));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        int r = binarySearch(arr, x);
        int l = r - 1;
        while(k-- > 0){
            if(l < 0){
                r++;
            }else if(r >= n){
                l--;
            }else if(Math.abs(arr[l] - x) > Math.abs(arr[r] - x)){
                r++;
            }else{
                l--;
            }
        }
        for(int i = l + 1; i < r; i++){
            list.add(arr[i]);
        }
        return list;
    }
    public static int binarySearch(int[] arr, int target){
        int n = arr.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = (l + r) / 2;
            if(arr[mid] >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

}
