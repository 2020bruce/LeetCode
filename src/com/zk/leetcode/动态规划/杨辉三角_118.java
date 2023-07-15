package com.zk.leetcode.动态规划;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角_118 {
    public static void main(String[] args) {
        List<List<Integer>> lists = generate(3);
        for(List<Integer> l : lists){
            for(int i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> l = new ArrayList<>();
        l.add(1);
        list.add(l);

        if (numRows == 1) {
            return list;
        }

        for(int i = 1; i < numRows; i++){
            l = new ArrayList<>();
            for(int j = 0; j < i + 1; j++){
                if(j == 0 || j == i){
                    l.add(1);
                }else{
                    l.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
                }
            }
            list.add(l);
        }
        return list;

    }
}













