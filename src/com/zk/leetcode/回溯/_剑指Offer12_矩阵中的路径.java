package com.zk.leetcode.回溯;

public class _剑指Offer12_矩阵中的路径 {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "SFCEESEC";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    static boolean[][] isVisited;
    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                isVisited = new boolean[m][n];
                if(backtrack(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    static int[][] directions = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    private static boolean backtrack(char[][] board, int x, int y, String word, int idx) {
        int len = word.length();
        if(idx == len - 1 && word.charAt(idx) == board[x][y]){
            return true;
        }
        if(word.charAt(idx) != board[x][y]){
            return false;
        }
        isVisited[x][y] = true;
        int m = board.length, n = board[0].length;
        for (int[] direction : directions) {
            int newX = x + direction[0], newY = y + direction[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n &&
                    !isVisited[newX][newY]) {
                if(backtrack(board, newX, newY, word, idx + 1)){
                    return true;
                }
            }
        }
        isVisited[x][y] = false;

        return false;
    }


}











