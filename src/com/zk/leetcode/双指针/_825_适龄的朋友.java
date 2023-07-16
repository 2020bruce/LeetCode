package com.zk.leetcode.双指针;

import java.util.Arrays;

public class _825_适龄的朋友 {
    public static void main(String[] args) {
        int[] ages = {49,110,13,39,45,104,9,114,86,72,13,24,10,77,103,85,9,21,66,25};
        int requests = numFriendRequests(ages);
        System.out.println(requests);
    }
    public static int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        System.out.println(Arrays.toString(ages));
        int ans = 0;
        int l = 0, r = 0;
        for(int i = 0; i < n; i++){
            if(ages[i] < 7){
                continue;
            }
            if(i != 0 && ages[i] == ages[i - 1]){
                ans += r - l;
                continue;
            }
            l = binarySearchLeft(ages, ages[i], 0, i);
            r = binarySearchRight(ages, 2 * ages[i] - 14, i, n - 1);
            System.out.println(l + " " + r);
            if(r > l){
                ans += r - l;
            }
        }
        return ans;
    }

    private static int binarySearchLeft(int[] ages, int target, int begin, int end) {
        int l = begin, r = end;
        while(l < r){
            int mid = (l + r) / 2;
            if(ages[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    private static int binarySearchRight(int[] ages, int target, int begin, int end){
        int l = begin, r = end;

        while(l < r){
            int mid = (l + r + 1) >> 1;
            if(ages[mid] >= target){
                r = mid - 1;
            }else{
                l = mid;
            }
        }
        return r;
    }
}

































