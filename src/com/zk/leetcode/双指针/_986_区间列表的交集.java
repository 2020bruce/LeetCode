package com.zk.leetcode.双指针;

import java.util.ArrayList;
import java.util.List;

public class _986_区间列表的交集 {
    public static void main(String[] args) {
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] ints = intervalIntersection(firstList, secondList);
        for(int[] arr: ints){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}



















