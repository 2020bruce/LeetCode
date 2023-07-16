package com.zk.leetcode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _834_树中距离之和 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        int[] sum = sumOfDistancesInTree(n, edges);
        System.out.println(Arrays.toString(sum));
    }

    /**
     * u表示父节点，v表示子节点，dp[u] 表示所有子节点到i节点的距离之和，sz[u] 表示包括自己在内所有子节点的个数，
     * ans[u] 表示所有子节点到i节点的距离之和。
     * 1.dp[u] = dp[v] + sz[v];
     * 2.ans[u] = dp[u];
     * 3.每次遍历结束后进行一次换根;
     * 4.换根只需要改变dp[u]、dp[v]、sz[u]和sz[v];
     *
     * @param n
     * @param edges
     * @return
     */
    private static int[] ans;
    private static int[] dp;
    private static int[] sz;
    private static List<List<Integer>> tree;
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        ans = new int[n];
        dp = new int[n];
        sz = new int[n];
        tree = new ArrayList<>();

        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            tree.get(from).add(to);
            tree.get(to).add(from);
        }

        dfs1(0, -1);
        dfs2(0, -1);

        return ans;
    }

    /**
     *
     * @param u 当前节点
     * @param f 当前节点的父节点
     */
    private static void dfs1(int u, int f) {
        dp[u] = 0;
        sz[u] = 1;
        for(int v : tree.get(u)){
            if(v == f){
                continue;
            }
            dfs1(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    private static void dfs2(int u, int f){
        ans[u] = dp[u];
        for(int v : tree.get(u)){
            if(v == f){
                continue;
            }
            int pu = dp[u], pv = dp[v];
            int su = sz[u], sv = sz[v];
            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];
            dfs2(v, u);
            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }
}















































