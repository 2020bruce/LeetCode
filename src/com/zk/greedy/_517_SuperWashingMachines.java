package com.zk.greedy;

import java.util.Arrays;
import java.util.Map;

public class _517_SuperWashingMachines {
    public static void main(String[] args) {
        int[] machines = {1,0,5};
        int minMoves = findMinMoves(machines);
        System.out.println(minMoves);
    }

    /**
     * 分两种情况
     * 1.洗衣机中的衣服往一边移动
     * 2.中间洗衣机的衣服往两边移动
     * @param machines
     * @return
     */
    public static int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = Arrays.stream(machines).sum();

        if(sum % n != 0){
            return -1;
        }
        int average = sum / n;
        int temp = 0;
        int count = 0;
        int ans = 0;
        for (int machine : machines) {
            temp = machine - average;
            count += temp;
            ans = Math.max(temp, Math.max(ans, Math.abs(count)));
        }
        return ans;
    }
}




















