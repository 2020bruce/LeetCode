package com.zk.leetcode.贪心算法;

public class 加油站_134 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int sum = 0;
        int minSum = 0;
        for(int i = 0; i < n; i++){//选择一经做出将不能改变
            sum += gas[i] - cost[i];
            if(sum < minSum){
                start = i + 1;
                minSum = sum;
            }
        }
        if(sum < 0){
            start = -1;
        }
        return start == n ? 0 : start;
    }
}
