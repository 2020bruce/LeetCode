package com.zk.leetcode.二分查找;

public class _74_搜索二维矩阵 {
    public static void main(String[] args) {
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1,3}};
        int target = 3;
        boolean b = searchMatrix(matrix, target);
        System.out.println(b);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int bi = 0, bj = 0, ei = m - 1, ej = n - 1;
        while(bi <= ei && bj <= ej){
            int mi = (bi + ei) / 2;
            int mj = (bj + ej) / 2;
            if(matrix[mi][mj] == target){
                return true;
            }else if(matrix[mi][mj] > target){
                if(ej > 0){
                    ej--;
                }else{
                    ei--;
                    ej = n - 1;
                }
            }else{
                if(bj < n - 1){
                    bj++;
                }else{
                    bi++;
                    bj = 0;
                }

            }
        }
        return false;
    }

}
