package com.zk.leetcode.深度优先搜索;

import java.util.Arrays;

public class _130_被围绕的区域 {
    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(board);
        for(char[] arr : board){
            System.out.println(Arrays.toString(arr));
        }
    }
    static boolean[][] visited;
    static int n, m;
    public static void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n - 1 || j == m - 1){
                    if(board[i][j] == 'O' && !visited[i][j]){
                        dfs(board, i, j);
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }


    }
    private static void dfs(char[][] board, int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= m || board[i][j] != 'O' || visited[i][j]){
            return;
        }
        board[i][j] = 'A';
        visited[i][j] = true;
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
