package com.zk.leetcode.深度优先搜索;

import java.util.Arrays;

public class _529_扫雷游戏 {
    public static void main(String[] args) {
        char[][] board = {
                {'E','E','E','E','E'},
                {'E','E','M','E','E'},
                {'E','E','E','E','E'},
                {'E','E','E','E','E'}
        };
        int[] click = {3,0};
        char[][] chars = updateBoard(board, click);
        for(char[] c : chars){
            System.out.println(Arrays.toString(c));
        }
    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }else if(board[x][y] == 'E'){
            dfs(board, x, y);
        }
        return board;
    }

    static int[][] directions = {{1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    private static void dfs(char[][] board, int x, int y) {
        if((x >= board.length) || (x < 0) || (y >= board[0].length) || (y < 0) || (board[x][y] == 'X') ||
                (board[x][y] == 'B') || ((board[x][y] >= 49) && (board[x][y] <= 56))){
            return;
        }
        int num = 0;
        for(int i = 0; i < directions.length; i++){
            int dx = directions[i][0], dy = directions[i][1];
            if((x + dx < board.length) && (x + dx >= 0) && (y + dy < board[0].length) && (y + dy >= 0) && board[x + dx][y + dy] == 'M' ){
                num++;
            }
        }
        if(num == 0){
            board[x][y] = 'B';
            for(int i = 0; i < directions.length; i++){
                int dx = directions[i][0], dy = directions[i][1];
                dfs(board, dx + x, dy + y);
            }
        }else{
            board[x][y] = (char)('0' + num);
        }

    }
}
































