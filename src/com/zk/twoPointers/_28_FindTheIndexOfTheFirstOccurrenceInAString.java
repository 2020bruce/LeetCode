package com.zk.twoPointers;

import java.util.Arrays;

public class _28_FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        String haystack = "aecaeaecaeda", needle = "aecaed";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if(m > n){
            return -1;
        }
        int[] next = new int[m];
        for(int i = 1, j = 0; i < m; i++){
            while(j > 0 && needle.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));
        for(int i = 0, j = 0; i < n; i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(m == j){
                return i - m + 1;
            }
        }
        return -1;
    }
}
