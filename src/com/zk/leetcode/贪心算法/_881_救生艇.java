package com.zk.leetcode.贪心算法;

import java.util.Arrays;

public class _881_救生艇 {
    public static void main(String[] args) {
        int[] people = {3,2,2,1,3,5,3,4};
        int limit = 5;
        int i = numRescueBoats(people, limit);
        System.out.println(i);
    }
    public static int numRescueBoats(int[] people, int limit) {
        Integer[] temp = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, (o1, o2)->o2-o1);
        System.out.println(Arrays.toString(temp));
        int res = 0;
        int l = 0, r = people.length - 1;
        while(l < r){
            if(temp[l] + temp[r] <= limit){
                r--;
            }
            l++;
            res++;
        }
        if(l == r){
            res++;
        }

        return res;
    }
}
















