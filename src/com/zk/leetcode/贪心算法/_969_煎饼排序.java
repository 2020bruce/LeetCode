package com.zk.leetcode.贪心算法;

import java.util.ArrayList;
import java.util.List;

public class _969_煎饼排序 {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1};
        List<Integer> list = pancakeSort(arr);
        for(Integer item : list){
            System.out.print(item + " ");
        }
    }
    public static List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = n; i >= 1; i--){
            for(int j = 0; j < n; j++){
                if(arr[j] == i){
                    ans.add(j + 1);
                    ans.add(i);
                    reverse(arr, j);
                    reverse(arr, i - 1);
                    break;
                }
            }
        }
        return ans;
    }

    private static void reverse(int[] arr, int end) {
        int count = (end + 1) / 2;
        for(int begin = 0; begin < count; begin++){
            int temp = arr[begin];
            arr[begin] = arr[end - begin];
            arr[end - begin] = temp;
        }
    }
}
