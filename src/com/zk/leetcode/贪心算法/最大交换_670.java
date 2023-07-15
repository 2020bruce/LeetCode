package com.zk.leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class 最大交换_670 {
    public static void main(String[] args) {
        int i = maximumSwapBest(1993);
        System.out.println(i);
    }

    //官方版本
    public static int maximumSwapBest(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        char[] charArray = s.toCharArray();

        int[] nums = new int[10];
        for(int i = 0; i < n; i++){
            nums[charArray[i] - '0'] = i;
        }
        for(int i = 0; i < n; i++){
            for(int j = 9; j > charArray[i] - '0'; j--){
                if(i < nums[j]){
                    swap(charArray, i, nums[j]);
                    return Integer.valueOf(new String(charArray));
                }
            }
        }

        return num;
    }

    private static void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }


    //自己写版本
    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int[] nums = new int[n];
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            nums[i] = chars[i] - 48;
            arr[i][0] = i;
            arr[i][1] = chars[i] - 48;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int t = 0;
        int x = 0;
        for(int i = 0; i < n; i++){
            if(arr[i][0] != i && i + 1 < n && arr[i][1] == arr[i + 1][1]){
                x++;
            }
            if(arr[i][0] != i && i + 1 < n && arr[i][1] != arr[i + 1][1]){

                t = nums[i - x];
                nums[i - x] = arr[i][1];
                nums[arr[i][0]] = t;
                System.out.println(i);
                System.out.println(arr[i][0]);
                break;

            }
        }
        String s = "";
        for(int i = 0; i < n; i++){
            s += String.valueOf(nums[i]);
        }
        return Integer.valueOf(s);
    }
}
