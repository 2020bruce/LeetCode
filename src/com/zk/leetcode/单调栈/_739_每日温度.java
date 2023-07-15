package com.zk.leetcode.单调栈;

import java.util.Arrays;
import java.util.Stack;

public class _739_每日温度 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(temperatures);
        Arrays.stream(ints).forEach((i)->{
            System.out.print(i + " ");
        });
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] into = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int t = stack.pop();
                into[t] = i - t;
            }
            stack.push(i);
        }
        return into;
    }
}
