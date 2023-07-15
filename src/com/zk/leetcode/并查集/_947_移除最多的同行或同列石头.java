package com.zk.leetcode.并查集;

public class _947_移除最多的同行或同列石头 {
    public static void main(String[] args) {
        int[][] stones = {{0,1},{1,0},{1,1}};
        int i = removeStones(stones);
        System.out.println(i);
    }
    public static int removeStones(int[][] stones) {
        int n = stones.length;
        UF uf = new UF(n);
        for(int i = 1; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    uf.union(i, j);
                    if(uf.find(i) != uf.find(j)){
                        break;
                    }
                }
            }
        }
        uf.show();
        return n - uf.connectedCount();
    }
}
