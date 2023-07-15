package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _967_连续差相同的数字 {
    public static void main(String[] args) {
        int n = 3, k = 7;
        int[] ints = numsSameConsecDiff(n, k);
        System.out.println(Arrays.toString(ints));

    }
    static List<Integer> list = new ArrayList<>();
    public static int[] numsSameConsecDiff(int n, int k) {
        backtrack(n, k, new StringBuilder());
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void backtrack(int n, int k, StringBuilder builder){
        if(builder.length() == n){
            list.add(Integer.valueOf(builder.toString()));
            return;
        }
        for(int i = 0; i <= 9; i++){
            if(builder.length() == 0 && i == 0){
                continue;
            }
            if(builder.length() == 0 || Math.abs(builder.charAt(builder.length() - 1) - '0' - i) == k){
                builder.append(i);
                backtrack(n, k, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}
