package com.zk.divideAndConquer;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 2, 5, 10, 8, 7, 8, -1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static int[] aux;
    private static void sort(int[] arr, int lo, int hi){
        if(lo >= hi){
            return;
        }
        aux = new int[arr.length];
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int l = lo, r = mid + 1;
        int n = hi - lo + 1;
        System.arraycopy(arr, lo, aux, lo, n);
        for(int i = lo; i <= hi; i++){
            if(l > mid){
                arr[i] = aux[r++];
            }else if(r > hi){
                arr[i] = aux[l++];
            }else if(aux[l] <= aux[r]){
                arr[i] = aux[l++];
            }else{
                arr[i] = aux[r++];
            }
        }

    }
}
















