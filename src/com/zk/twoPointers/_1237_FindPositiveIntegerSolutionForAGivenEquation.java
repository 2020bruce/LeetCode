package com.zk.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1237_FindPositiveIntegerSolutionForAGivenEquation {
    public static void main(String[] args) {
        int z = 5;
        List<List<Integer>> list = findSolution(Integer::sum, z);
        for(List<Integer> ans : list){
            for(int arg : ans){
                System.out.print(arg + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> findSolutionSelf(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int x = 1; x < z; x++){
            for(int y = 1; y < z; y++){
                if(customfunction.f(x, y) == z){
                    ans.add(Arrays.asList(x, y));
                }
            }
        }
        return ans;
    }

    /**
     * 双指针
     */
    public static List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int x = 1, y = 1000; x <= 1000 && y > 0; x++){
            while(y > 0 && customfunction.f(x, y) > z){
                y--;
            }
            if(y > 0 && customfunction.f(x, y) == z){
                ans.add(Arrays.asList(x, y));
            }
        }
        return ans;
    }
}


interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    int f(int x, int y);
}












