package com.zk.leetcode.回溯;

public class _79_单词搜索 {
    public static void main(String[] args) {
        char[][] board = {
                {'a','a','b','a','a','b'},
                {'a','a','b','b','b','a'},
                {'a','a','a','a','b','a'},
                {'b','a','b','b','a','b'},
                {'a','b','b','a','b','a'},
                {'b','a','a','a','a','b'}
        };
        String word = "bbbbab";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    static boolean[][] isVisited;
    static boolean flag = false;
    public static boolean exist(char[][] board, String word) {
        isVisited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                isVisited[i][j] = true;
                backtrack(board, i, j, word, 0);
                isVisited[i][j] = false;
            }
        }
        return flag;
    }

    private static void backtrack(char[][] board, int i, int j, String word, int k) {
        if(board[i][j] != word.charAt(k)){
            return;
        }

        int len = word.length();
        if(k == len - 1 && board[i][j] == word.charAt(k)){
            flag = true;
            return;
        }
        int n = board.length;
        int m = board[0].length;

        if(i > 0 && !isVisited[i - 1][j]){
            isVisited[i - 1][j] = true;
            backtrack(board, i - 1, j, word, k + 1);
            isVisited[i - 1][j] = false;
        }
        if(i < n - 1 && !isVisited[i + 1][j]){
            isVisited[i + 1][j] = true;
            backtrack(board, i + 1, j, word, k + 1);
            isVisited[i + 1][j] = false;
        }
        if(j > 0 && !isVisited[i][j - 1]){
            isVisited[i][j - 1] = true;
            backtrack(board, i, j - 1, word, k + 1);
            isVisited[i][j - 1] = false;
        }
        if(j < m - 1 && !isVisited[i][j + 1]){
            isVisited[i][j + 1] = true;
            backtrack(board, i, j + 1, word, k + 1);
            isVisited[i][j + 1] = false;
        }

    }
}
















