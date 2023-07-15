package com.zk.leetcode.深度优先搜索;

//单点连通问题
public class DepthFirstSearch {
    boolean[] marked; //是否访问过
    int count; //与开始节点连通节点的个数
    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    public void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for(int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }
    public boolean marked(int w){
        return marked[w];
    }
    public int count(){
        return count;
    }
}
