package com.zk.leetcode.前缀和;

public class _304_二维区域和检索_矩阵不可变 {

    public static void main(String[] args) {
        _304_二维区域和检索_矩阵不可变 obj = new _304_二维区域和检索_矩阵不可变(new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        });
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));;
        System.out.println(obj.sumRegion(1, 2, 2, 4));;
    }
    int[][] sums;

    public _304_二维区域和检索_矩阵不可变(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sums = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
