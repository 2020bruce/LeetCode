package com.zk.leetcode.滑动窗口;

public class _2106_摘水果 {
    public static void main(String[] args) {
        int[][] fruits = {{0,3},{6,4},{8,5}};
        int startPos = 3, k = 2;
        int maxTotalFruits = maxTotalFruits(fruits, startPos, k);
        System.out.println(maxTotalFruits);
    }

    /**
     * 1.对fruits进行滑动窗口；
     * 2.r一直往右移动，l直到l和r的距离大于k时向左滑动。
     *
     * @param fruits
     * @param startPos
     * @param k
     * @return
     */
    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int left = 0, right = 0;
        int sum = 0;
        int ans = 0;
        while(right < n){
            sum += fruits[right][1];
            while(left <= right && step(fruits, startPos, left, right) > k){
                sum -= fruits[left][1];
                left++;
            }
            ans = Math.max(sum, ans);
            right++;
        }
        return ans;
    }

    private static int step(int[][] fruits, int startPos, int left, int right) {
        if(fruits[right][0] <= startPos){
            return startPos - fruits[left][0];
        }else if(fruits[left][0] >= startPos){
            return fruits[right][0] - startPos;
        }else{
            if(startPos - fruits[left][0] < fruits[right][0] - startPos){
                return (startPos - fruits[left][0]) * 2 + fruits[right][0] - startPos;
            }else{
                return (fruits[right][0] - startPos) * 2 + startPos - fruits[left][0];
            }
        }
    }
}
























