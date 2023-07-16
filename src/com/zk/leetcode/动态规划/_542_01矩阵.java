package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _542_01矩阵 {
    public static void main(String[] args) {
        int[][] mat = {
                {0,1,0},
                {0,1,0},
                {0,1,0},
                {0,1,0},
                {0,1,0}
        };
        int[][] matrix = updateMatrix(mat);
        for(int[] arr : matrix){
            System.out.println(Arrays.toString(arr));
        }
    }
    public static int[][] updateMatrix(int[][] mat) {
        int[][] arr = new int[mat.length][mat[0].length];
        //先处理左上数据
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] != 0){
                    arr[i][j] = 100000;
                    if(i > 0){
                        arr[i][j] = Math.min(arr[i][j], arr[i - 1][j] + 1);
                    }
                    if(j > 0){
                        arr[i][j] = Math.min(arr[i][j], arr[i][j - 1] + 1);
                    }
                }
            }
        }
        //再处理右下数据
        for(int i = mat.length - 1; i >= 0; i--){
            for(int j = mat[i].length - 1; j >= 0; j--){
                if(mat[i][j] != 0){
                    if(i < mat.length - 1){
                        arr[i][j] = Math.min(arr[i][j], arr[i + 1][j] + 1);
                    }
                    if(j < mat[i].length - 1){
                        arr[i][j] = Math.min(arr[i][j], arr[i][j + 1] + 1);
                    }
                }
            }
        }


        return arr;
    }
}















