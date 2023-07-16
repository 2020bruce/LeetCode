package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _310_最小高度树 {
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1,0},{1,2},{1,3}};
        List<Integer> trees = findMinHeightTrees(n, edges);
        trees.forEach((integer -> {
            System.out.print(integer + " ");
        }));
    }
    static boolean[] isVisited;
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        isVisited = new boolean[n];
        Graph graph = new Graph(n);
        for(int[] edge : edges){
            graph.addEdge(edge[0], edge[1]);
        }
        int minDepth = Integer.MAX_VALUE;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int d = depth(graph, i, 0);
            minDepth = Math.min(minDepth, d);
            isVisited = new boolean[n];
            ArrayList<Integer> temp = map.getOrDefault(d, new ArrayList<>());
            temp.add(i);
            map.put(d, temp);
        }

        return map.get(minDepth);
    }

    private static int depth(Graph graph, int begin, int deep) {
        isVisited[begin] = true;
        List<Integer> adj = graph.adj(begin);
        int max = deep;
        for(int t : adj){
            if(!isVisited[t]){
                max = Math.max(max, depth(graph, t, deep + 1));
            }
        }
        return max;
    }

    //首先找到距离节点 0 的最远节点 x，然后找到距离节点 x 的最远节点 y，然后找到节点 x 与节点 y 的路径，然后找到根节点.
    public static List<Integer> findMinHeightTreesBetter(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        /* 找到与节点 0 最远的节点 x */
        int x = findLongestNode(0, parent, adj);
        /* 找到与节点 x 最远的节点 y */
        int y = findLongestNode(x, parent, adj);
        /* 求出节点 x 到节点 y 的路径 */
        List<Integer> path = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    public static int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[u] = 0;
        dfs(u, dist, parent, adj);
        int maxdist = 0;
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (dist[i] > maxdist) {
                maxdist = dist[i];
                node = i;
            }
        }
        return node;
    }

    public static void dfs(int u, int[] dist, int[] parent, List<Integer>[] adj) {
        for (int v : adj[u]) {
            if (dist[v] < 0) {
                dist[v] = dist[u] + 1;
                parent[v] = u;
                dfs(v, dist, parent, adj);
            }
        }
    }
}




























