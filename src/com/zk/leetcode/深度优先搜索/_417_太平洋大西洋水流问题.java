package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _417_太平洋大西洋水流问题 {
    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        List<List<Integer>> lists = pacificAtlantic(heights);
        for(List<Integer> list : lists){
            list.forEach((l) -> System.out.print(l + " "));
            System.out.println();
        }

    }
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n]; // 太平洋
        boolean[][] atlantic = new boolean[m][n]; // 大西洋
        boolean[][] isVisited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(heights, pacific, atlantic, isVisited, i, j, i, j);
                isVisited = new boolean[m][n];
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private static void dfs(int[][] heights, boolean[][] pacific, boolean[][] atlantic, boolean[][] isVisited, int i, int j, int p, int q) {
        int m = heights.length, n = heights[0].length;
        if(p <= 0 || q <= 0){
            pacific[i][j] = true;
        }
        if(p >= m - 1 || q >= n - 1){
            atlantic[i][j] = true;
        }
        isVisited[p][q] = true;
        for(int k = 0; k < direction.length; k++){
            int x = p + direction[k][0], y = q + direction[k][1];
            if(x >= 0 && x <= m - 1 && y >= 0 && y <= n - 1){
                if(heights[p][q] >= heights[x][y] && !isVisited[x][y]){
                    dfs(heights, pacific, atlantic, isVisited, i, j, x, y);
                }
            }
        }
    }

}










































