package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class 所有可能的路径_797 {
    public static void main(String[] args) {
        int[][] graph = {
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        };
        List<List<Integer>> list = allPathsSourceTarget(graph);
        for(List<Integer> l : list){
            for(int ll : l){
                System.out.print(ll + " ");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> lists = new ArrayList<>();
    static List<Integer> list = new ArrayList();
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0);
        return lists;
    }

    private static void dfs(int[][] graph, int begin) {
        int n = graph.length;
        list.add(begin);
        if(begin == n - 1){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i : graph[begin]){

            dfs(graph, i);
            list.remove(list.size() - 1);
        }

    }
}
