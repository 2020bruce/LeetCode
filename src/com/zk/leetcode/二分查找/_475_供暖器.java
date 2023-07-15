package com.zk.leetcode.二分查找;

import java.util.Arrays;

public class _475_供暖器 {
    public static void main(String[] args) {
        int[] houses = {1,2,3,4}, heaters = {1,4};
        int radius = findRadius(houses, heaters);
        System.out.println(radius);
    }
    public static int findRadius(int[] houses, int[] heaters) {
        int m = houses.length, n = heaters.length;
        Arrays.sort(heaters);
        int ans = 0;
        for(int i = 0; i < m; i++){
            int l = 0, r = n - 1;
            while(l < r){
                int mid = (l + r) / 2;
                if(heaters[mid] == houses[i]){
                    break;
                }else if(heaters[mid] < houses[i]){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            int temp = Integer.MAX_VALUE;
            if(l == r){
                temp = Math.min(temp, Math.abs(heaters[l] - houses[i]));
                if(l - 1 >= 0){
                    temp = Math.min(temp, Math.abs(heaters[l - 1] - houses[i]));
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}
