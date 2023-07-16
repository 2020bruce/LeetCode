package com.zk.leetcode.回溯;

import java.util.*;

public class _51_N皇后 {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> lists = solveNQueens(n);
        for(List<String> list : lists){
            list.forEach(o-> System.out.print(o + " "));
            System.out.println();
        }
    }

    static List<List<String>> lists = new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        int[] queenPlace = new int[n];
        Arrays.fill(queenPlace, -1);
        Set<Integer> columns = new HashSet<>();
        HashSet<Integer> leftDiagonal = new HashSet<>();
        HashSet<Integer> rightDiagonal = new HashSet<>();
        backtrace(n, 0, queenPlace, columns, leftDiagonal, rightDiagonal);
        return lists;
    }

    private static void backtrace(int n, int row,
                                  int[] queenPlace,
                                  Set<Integer> columns,
                                  HashSet<Integer> leftDiagonal,
                                  HashSet<Integer> rightDiagonal) {
        if(row == n){
            List<String> list = new ArrayList<>();
            char[] s = new char[n];
            Arrays.fill(s, '.');

            for(int i = 0; i < n; i++){
                s[queenPlace[i]] = 'Q';
                list.add(new String(s));
                s[queenPlace[i]] = '.';
            }
            lists.add(list);
            return;
        }
        for(int column = 0; column < n; column++){
            if(columns.contains(column)){
                continue;
            }
            int leftDiag = row - column;
            if(leftDiagonal.contains(leftDiag)){
                continue;
            }
            int rightDiag = row + column;
            if(rightDiagonal.contains(rightDiag)){
                continue;
            }
            queenPlace[row] = column;
            columns.add(column);
            leftDiagonal.add(leftDiag);
            rightDiagonal.add(rightDiag);
            backtrace(n, row + 1, queenPlace, columns, leftDiagonal, rightDiagonal);
            queenPlace[row] = -1;
            columns.remove(column);
            leftDiagonal.remove(leftDiag);
            rightDiagonal.remove(rightDiag);
        }

    }

}