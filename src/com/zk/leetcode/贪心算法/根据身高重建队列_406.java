package com.zk.leetcode.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 根据身高重建队列_406 {
    public static void main(String[] args) {
        int[][] people = {{7,1},{4,4},{7,0},{5,0},{6,1},{5,2}};
        int[][] queue = reconstructQueue(people);
        for(int[] arr : queue){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        int[][] arr = new int[people.length][2];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o2[0] - o1[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int[] info : people){
            list.add(info[1], info);
        }
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}


















