package com.zk.greedy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _757_SetIntersectionSizeAtLeastTwo {
    public static void main(String[] args) {
        // {{1,3},{3,7},{8,9}} 5
        // {{1,2},{2,3},{2,4},{4,5}} 5
        int[][] intervals = {{1,3},{1,4},{2,5},{3,5}};// 3
        int sizeTwo = intersectionSizeTwo(intervals);
        System.out.println(sizeTwo);
    }

    /**
     * 定义一个List<Integer> temp[]数组，temp[i]存储的是第i个数组所选中的整数。
     * 1.先对intervals进行前一个数字的排序
     * 2.对intervals进行从后往前的遍历
     * 3.若intervals[n - 2][1]<intervals[n - 1][0], intervals[n - 1][0]再与前一个intervals[n - 3][1]进行比较
     * 4.若intervals[n - 2][1]>=intervals[n - 1][0], intervals[n - 1][0]放入temp[i]中
     * 5.temp[i]中数字的个数>2时退出循环
     * @param intervals
     * @return
     */
    public static int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int ans = 0;
        int m = 2;
        int n = intervals.length;
        List<Integer>[] temp = new ArrayList[n];
        for(int i = 0; i < n; i++){
            temp[i] = new ArrayList<>();
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = intervals[i][0], k = temp[i].size(); k < m; j++, k++){
                ans++;
                for(int p = i - 1; p >= 0; p--){
                    if(intervals[p][1] < j){
                        break;
                    }
                    temp[p].add(j);
                }
            }
        }

        return ans;

    }
}





















