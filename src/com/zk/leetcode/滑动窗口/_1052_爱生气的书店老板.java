package com.zk.leetcode.滑动窗口;

public class _1052_爱生气的书店老板 {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5}, grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        int i = maxSatisfied(customers, grumpy, minutes);
        System.out.println(i);
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int mostSatisfiedCustomers = 0;
        for(int i = 0; i < n; i++){
            if(grumpy[i] == 0){
                mostSatisfiedCustomers += customers[i];
            }
        }
        int increase = 0;
        for(int i = 0; i < minutes; i++){
            if(grumpy[i] == 1){
                increase += customers[i];
            }
        }
        int maxIncrease = increase;
        for(int i = minutes; i < n; i++){
            increase = increase - customers[i - minutes] * grumpy[i - minutes] + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return mostSatisfiedCustomers + maxIncrease;
    }
}















































