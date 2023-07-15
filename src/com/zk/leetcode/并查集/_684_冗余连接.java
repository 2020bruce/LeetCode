package com.zk.leetcode.并查集;

import java.util.Arrays;

public class _684_冗余连接 {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        int[] ints = findRedundantConnection(edges);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] findRedundantConnection(int[][] edges) {
        int length = edges.length;
        int[] res = new int[2];
        UF uf = new UF(length);
        for(int[] edge : edges){
            int to = edge[0] - 1;
            int from = edge[1] - 1;
            int findFrom = uf.find(from);
            int findTo = uf.find(to);
            if(findFrom != -1 && findTo != -1 && findFrom == findTo){
                res[0] = to + 1;
                res[1] = from + 1;
            }else{
                uf.union(to, from);
            }
        }
        return res;
    }
}





















