package com.zk.leetcode.并查集;

import java.util.Arrays;
/*
    并查集初始化父链接数组为-1
    根节点为负数，下面子节点的数量为根节点的绝对值
 */
public class UF {
    private int count;
    private int[] id;//父链接数组
    public UF(int N){
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = -1;
        }
    }
    public int find(int p){
        int root = p;
        while(id[root] >= 0){
            root = id[root];
        }
        while(p != root){
            int t = id[p];
            id[p] = root;
            p = t;
        }
        return root;
    }
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j){
            return;
        }
        if(id[i] > id[j]){
            id[j] += id[i];
            id[i] = j;
        }else{
            id[i] += id[j];
            id[j] = i;
        }
    }
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    public void show(){
        System.out.println(Arrays.toString(id));
    }
    public int connectedCount(){
        int res = 0;
        for(int i =0; i < count; i++){
            if(id[i] <= -1){
                res++;
            }
        }
        return res;
    }
}
