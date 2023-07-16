package com.zk.leetcode.深度优先搜索;

public class Test {
    public static void main(String[] args) {
        Graph G = new Graph(7);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 5);
        G.addEdge(0, 6);
        G.addEdge(3, 4);
        G.addEdge(3, 5);
        G.addEdge(4, 5);
        G.addEdge(4, 6);
        DepthFirstSearch search = new DepthFirstSearch(G, 0);
        System.out.println(search.count());
    }
}
