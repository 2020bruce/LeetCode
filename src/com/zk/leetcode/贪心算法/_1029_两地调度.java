package com.zk.leetcode.贪心算法;

import java.util.Arrays;

public class _1029_两地调度 {
    public static void main(String[] args) {
        int[][] costs = {{10,20},{30, 200},{400,50},{30,20}};
        int cost = twoCitySchedCost(costs);
        System.out.println(cost);
    }
    public static int twoCitySchedCost(int[][] costs) {
        int personCount = costs.length;
        Arrays.sort(costs, ((o1, o2) -> o1[0] - o2[0] - (o1[1] - o2[1])));
        int res = 0;
        int mid = personCount / 2;
        for(int i = 0; i < mid; i++){
            res += costs[i][0];
        }
        for(int i = mid; i < personCount; i++){
            res += costs[i][1];
        }
        return res;
    }
}
