package com.zk.leetcode.动态规划;

import java.util.Arrays;

public class _688_骑士在棋盘上的概率 {
    public static void main(String[] args) {
        int n = 3, k = 3, row = 0, column = 0;
        double v = knightProbability(n, k, row, column);
        System.out.println(v);
    }
    static Integer[][] position = {
            {2, -1},
            {2, 1},
            {-2, -1},
            {-2, 1},
            {1, -2},
            {1, 2},
            {-1, -2},
            {-1, 2}
    };
    public static double knightProbability(int n, int k, int row, int column) {
        double[][][] pro = new double[k + 1][n][n];
        for(int step = 0; step <= k; step++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(step == 0){
                        pro[step][i][j] = 1;
                        continue;
                    }
                    for(int m = 0; m < position.length; m++){
                        if(i + position[m][0] < n && i + position[m][0] >= 0 &&
                                j + position[m][1] < n && j + position[m][1] >= 0){
                            pro[step][i][j] += pro[step - 1][i + position[m][0]][j + position[m][1]] / 8;
                        }
                    }

                }
            }
        }
        for(double[][] arr : pro){
            for(double[] a : arr){
                System.out.println(Arrays.toString(a));
            }
            System.out.println();
        }

        return pro[k][row][column];
    }
}
