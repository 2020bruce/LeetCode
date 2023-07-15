package com.zk.leetcode.深度优先搜索;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class _365_水壶问题 {
    public static void main(String[] args) {
        int jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4;
        boolean canMeasureWater = canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity);
        System.out.println(canMeasureWater);
    }

    public static boolean canMeasureWater(int m, int n, int target) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<>();
        while(!stack.isEmpty()){
            if(seen.contains(hash(stack.peek()))){
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));
            int[] remain = stack.pop();
            int remainX = remain[0], remainY = remain[1];
            if(remainX == target || remainY == target || remainX + remainY == target){
                return true;
            }
            stack.push(new int[]{m, remainY});
            stack.push(new int[]{0, remainY});
            stack.push(new int[]{remainX, n});
            stack.push(new int[]{remainX, 0});
            stack.push(new int[]{remainX - Math.min(remainX, n - remainY), remainY + Math.min(remainX, n - remainY)});
            stack.push(new int[]{remainX + Math.min(remainY, m - remainX), remainY - Math.min(remainY, m - remainX)});
        }
        return false;
    }

    public static long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }

}



































