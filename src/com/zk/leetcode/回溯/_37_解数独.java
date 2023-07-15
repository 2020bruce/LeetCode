package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _37_解数独 {
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        for(char[] arr : board){
            System.out.println(Arrays.toString(arr));
        }
    }
    static boolean[][] lines = new boolean[9][9];
    static boolean[][] columns = new boolean[9][9];
    static boolean[][][] block = new boolean[3][3][9];
    static List<int[]> spaces = new ArrayList<>();
    static boolean valid;

    public static void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    lines[i][board[i][j] - '0' - 1] = true;
                    columns[j][board[i][j] - '0' - 1] = true;
                    block[i / 3][j / 3][board[i][j] - '0' - 1] = true;
                }else{
                    spaces.add(new int[]{i, j});
                }

            }
        }
        backtrack(board, 0);

    }

    private static void backtrack(char[][] board, int pos) {
        if(pos == spaces.size()){
            valid = true;
            return;
        }
        int row = spaces.get(pos)[0];
        int column = spaces.get(pos)[1];
        for(int i = 0; i < 9 && !valid; i++){
            if(!lines[row][i] && !columns[column][i] && !block[row / 3][column / 3][i]){
                board[row][column] = (char)('0' + i + 1);
                lines[row][i] = true;
                columns[column][i] = true;
                block[row / 3][column / 3][i] = true;
                backtrack(board, pos + 1);
                lines[row][i] = false;
                columns[column][i] = false;
                block[row / 3][column / 3][i] = false;
            }
        }
    }
}



















