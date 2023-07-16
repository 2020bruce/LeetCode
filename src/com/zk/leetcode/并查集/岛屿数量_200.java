package com.zk.leetcode.并查集;

import java.util.Arrays;

public class 岛屿数量_200 {
    public static void main(String[] args) { 
        char[][] grid = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        int i = numIslands(grid);
        System.out.println(i);

    }
    private static int[] id;//父链接数组
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        id = new int[n * m];
        int index = 0;
        if(grid[0][0] == '1'){
            id[index] = -1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    index++;
                    continue;
                }
                if(grid[i][j] == '0'){
                    id[index] = 1000;
                    index++;
                    continue;
                }else{
                    id[index] = -1;
                }
                if(i == 0){
                    if(grid[i][j - 1] == '1'){
                        union(index, index - 1);
                    }
                }else if(j == 0){
                    if(grid[i - 1][j] == '1'){
                        union(index, index - m);
                    }
                }else{
                    if(grid[i - 1][j] == '1'){
                        union(index, index - m);
                    }
                    if(grid[i][j - 1] == '1'){
                        union(index, index - 1);
                    }
                }
                index++;
            }
        }
        System.out.println(Arrays.toString(id));
        return connectedCount();
    }
    public static int find(int p){
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
    public static void union(int p, int q){
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
    public static int connectedCount(){
        int res = 0;
        for(int i =0; i < id.length; i++){
            if(id[i] < 0){
                res++;
            }
        }
        return res;
    }
}
