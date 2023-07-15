package com.zk.leetcode.前缀和;

public class _363_矩形区域不超过K的最大数值和 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1},
                {0,-2,3}
        };
        int k = 2;
        int maxSumSubmatrix = maxSumSubmatrix(matrix, k);
        System.out.println(maxSumSubmatrix);
    }
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int[] colSum = new int[m];
            for(int j = i; j < n; j++){
                for(int p = 0; p < m; p++){
                    colSum[p] += matrix[p][j];
                }
                max = Math.max(max, maxButLessK(colSum, k));
                if (max == k){
                    return k;
                }
            }
        }
        return max;
    }

    private static int maxButLessK(int[] colSum, int k) {
        int n = colSum.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += colSum[j];
                if(sum > ans && sum <= k){
                    ans = sum;
                }
                if(ans == k){
                    return k;
                }
            }
        }
        return ans;
    }
}



































