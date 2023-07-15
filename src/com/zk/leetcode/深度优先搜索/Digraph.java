package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.List;

//有向图
public class Digraph {
    private final int V; //顶点数目
    private int E;  //边的数目
    private List<Integer>[] adj;  //邻接表
    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for(int v = 0; v < V; v++){
            adj[v] = new ArrayList<>();
        }
    }
    public int V(){return V;}
    public int E(){return E;}
    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }
    public List<Integer> adj(int v){
        return adj[v];
    }
    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for(int v = 0; v < E; v++){
            for(int w : adj(v)){
                R.addEdge(w, v);
            }
        }
        return R;
    }
}
