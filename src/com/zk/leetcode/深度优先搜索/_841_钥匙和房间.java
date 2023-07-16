package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _841_钥匙和房间 {
    public static void main(String[] args) {
        Integer[][] rooms = {{1},{},{0,3},{1}};
        List<List<Integer>> lists = new ArrayList<>();
        for(Integer[] room : rooms){
            List<Integer> list = new ArrayList<>(Arrays.asList(room));
            lists.add(list);
        }
        for(List<Integer> l : lists){
            for(Integer i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        boolean b = canVisitAllRooms(lists);
        System.out.println(b);
    }
    static boolean[] isVisited;
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        for(int i = 0; i < n; i++){
            isVisited = new boolean[n];
            dfs(rooms, i);
            int count = 0;
            for(boolean b : isVisited){
                if(b){
                    count++;
                }
            }
            if(count == n){
                return true;
            }
        }
        return false;
    }

    public static void dfs(List<List<Integer>> rooms, int begin){
        isVisited[begin] = true;
        for(Integer key : rooms.get(begin)){
            if(!isVisited[key]){
                dfs(rooms, key);
            }
        }
    }
}








