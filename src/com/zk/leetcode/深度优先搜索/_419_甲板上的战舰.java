package com.zk.leetcode.深度优先搜索;

public class _419_甲板上的战舰 {
    public static void main(String[] args) {
        char[][] board = {
                {'X','.','.','X'},
                {'.','.','.','X'},
                {'.','.','.','X'}
        };
        int i = countBattleships(board);
        System.out.println(i);
    }
    public static int countBattleships(char[][] board) {
        int ans = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'X'){
                    ans++;
                    dfs(board, i, j);
                }
            }
        }
        return ans;
    }
    static int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    public static void dfs(char[][] board, int i, int j){
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == '.'){
            return;
        }
        board[i][j] = '.';
        for (int[] ints : direction) {
            dfs(board, i + ints[0], j + ints[1]);
        }
    }
}
