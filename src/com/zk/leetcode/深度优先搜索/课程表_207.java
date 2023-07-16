package com.zk.leetcode.深度优先搜索;

public class 课程表_207 {
    public static void main(String[] args) {
        int[][] prerequisites = {
                {1, 3},
                {2, 3},
                {0, 1},
                {0, 2}
        };
        boolean b = canFinish(4, prerequisites);
        System.out.println(b);
    }
    static boolean[] marked;
    static boolean[] onStack;
    static boolean flag = true;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        Graph graph = new Graph(numCourses);
        for(int i = 0; i < prerequisites.length; i++){
            graph.addEdge(prerequisites[i][1], prerequisites[i][0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!marked[i]){
                dfs(graph, i);
            }
        }
        return flag;
    }
    private static void dfs(Graph graph, int begin) {
        onStack[begin] = true;
        marked[begin] = true;
        for(int v : graph.adj(begin)){
            if(!marked[v]){
                dfs(graph, v);
                if(!flag){
                    return;
                }
            }else if(onStack[v]){
                flag = false;
                return;
            }
        }
        onStack[begin] = false;
    }
}













