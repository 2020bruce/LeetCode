package com.zk.leetcode.贪心算法;

public class _769_最多能完成排序的块 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1,0};
        int i = maxChunksToSorted(arr);
        System.out.println(i);
    }
    public static int maxChunksToSorted(int[] arr) {
        int m = 0, res = 0;
        for(int i = 0; i < arr.length; i++){
            m = Math.max(m, arr[i]);
            if(m == i){
                res++;
            }
        }
        return res;
    }
}
