package com.zk.leetcode.双指针;

import java.util.Arrays;

public class _165_比较版本号 {
    public static void main(String[] args) {
        String  version1 = "0.1", version2 = "1.1";
        int i = compareVersion(version1, version2);
        System.out.println(i);
    }
    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int[] array1 = Arrays.stream(split1).mapToInt(Integer::valueOf).toArray();
        int[] array2 = Arrays.stream(split2).mapToInt(Integer::valueOf).toArray();
        int i = 0;
        for(; i < Math.min(array1.length, array2.length); i++){
            if(array1[i] > array2[i]){
                return 1;
            }else if(array1[i] < array2[i]){
                return -1;
            }
        }
        while(i < array1.length){
            if(array1[i] != 0){
                return 1;
            }
            i++;
        }
        while(i < array2.length){
            if(array2[i] != 0){
                return -1;
            }
            i++;
        }
        return 0;
    }
}























