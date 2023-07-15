package com.zk.leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class 无重叠区间_435 {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        int i = eraseOverlapIntervals(intervals);
        System.out.println(i);

    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 1){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int n = intervals.length;
        int ans = 0;
        int right = intervals[0][1];
        for(int i = 1; i < n; i++){
            if(intervals[i][0] < right){
                ans++;
            }else{
                right = intervals[i][0];
            }
        }
        return ans;
    }
}










