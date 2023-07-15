package com.zk.leetcode.深度优先搜索;

import java.util.Arrays;

public class _685_冗余连接II {
    public static void main(String[] args) {
        int[][] edges = {{2,1},{3,1},{4,2},{1,4}};
        int[] redundantDirectedConnection = findRedundantDirectedConnection(edges);
        System.out.println(Arrays.toString(redundantDirectedConnection));
    }
    static int[] uf;
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int V = edges.length;
        uf = new int[V + 1];
        int[] parent = new int[V + 1];
        Arrays.fill(uf, -1);

        int conflict = -1;
        int circle = -1;
        for(int i = 0; i < V; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            if(parent[to] != 0){
                conflict = i;
            }else{
                parent[to] = from;
                if(find(from) == find(to)){
                    circle = i;
                }else{
                    union(to, from);
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(circle);
        System.out.println(conflict);
        if(conflict < 0){
            return new int[]{edges[circle][0], edges[circle][1]};
        }else{
            if(circle >= 0){
                return new int[]{parent[edges[conflict][1]], edges[conflict][1]};
            }else{
                return new int[]{edges[conflict][0], edges[conflict][1]};
            }
        }

    }
    private static int find(int p){
        int root = p;
        while(uf[root] >= 0){
            root = uf[root];
        }
        while(p != root){
            int t = uf[p];
            uf[p] = root;
            p = t;
        }
        return root;
    }
    private static void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j){
            return;
        }
        if(uf[i] > uf[j]){
            uf[j] += uf[i];
            uf[i] = j;
        }else{
            uf[i] += uf[j];
            uf[j] = i;
        }
    }
}























