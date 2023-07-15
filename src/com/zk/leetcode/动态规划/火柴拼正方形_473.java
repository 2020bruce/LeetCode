package com.zk.leetcode.动态规划;

import java.util.Arrays;
import java.util.Comparator;

public class 火柴拼正方形_473 {
    static boolean flag;
    public static void main(String[] args) {
        int[] matchsticks = {5,5,5,5,4,4,4,4,3,3,3,3};
        boolean makesquare = makesquare(matchsticks);
        System.out.println(makesquare);
    }

    public static boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        Integer[] copy = new Integer[n];
        for (int i = 0; i < n; i++) {
            copy[i] = matchsticks[i];
        }
        Arrays.sort(copy, Comparator.reverseOrder());
        int sum = 0;
        for(int matchstick : matchsticks){
            sum += matchstick;
        }
        if(sum % 4 != 0){
            return false;
        }
        int len = sum / 4;
        if(len < matchsticks[n - 1]){
            return false;
        }
        int[] k = new int[4];
        backtrack(copy, len, k, 0);
        return flag;
    }
    //int[] matchsticks = {5,5,5,5,4,4,4,4,3,3,3,3};
    private static void backtrack(Integer[] matchsticks, int len, int[] k, int index) {
        if(index == matchsticks.length){
            flag = true;
            return;
        }
        for(int i = 0; i < 4; i++){
            if(i > 0 && k[i - 1] == k[i]){
                continue;
            }
            if(k[i] + matchsticks[index] > len){
                continue;//去下一个桶
            }
            k[i] += matchsticks[index];
            backtrack(matchsticks, len, k, index + 1);
            k[i] -= matchsticks[index];
            /*剪枝二、表示说如果前面做出的选择之后，递归却没有找到任何一个合适的使得之和==target，
            那么撤销选择后一定为0，这个时候可以直接return false；举例：桶中加入7，target=8，
            但是递归完所有的火柴，不存在一个长度为1的，那么撤销选择后就为0了！*/
            if(k[i] == 0){
                return;
            }
        }
    }
}



















