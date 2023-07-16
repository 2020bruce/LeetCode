package com.zk.leetcode.哈希表;

import java.util.Arrays;

public class _73_矩阵置零 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeroes(matrix);
        for(int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagRow = false, flagCol = false;
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 0){
                flagRow = true;
            }
        }
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
                flagCol = true;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(flagRow){
            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }
        if(flagCol){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }

    }
}












































































