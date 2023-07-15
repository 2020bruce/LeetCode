package com.zk.leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class 最长数对链_646 {
    public static void main(String[] args) {
        int[][] pairs = {
                {1, 2},
                {2, 3},
                {3, 4}
        };
        int i = findLongestChain(pairs);
        System.out.println(i);
    }
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int max = 1;
        int temp = pairs[0][1];
        for(int i = 1; i < pairs.length; i++){
            if(pairs[i][0] > temp){
                max++;
                temp = pairs[i][1];
            }
        }
        return max;
    }
}
