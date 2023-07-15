package com.zk.leetcode.滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class _1703_得到连续K个1的最少相邻交换次数 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,0,1,1,0,1,0,1,1,1,1,0,1,0};
        int k = 7;
        int minMoves = minMoves(nums, k);
        System.out.println(minMoves); // 4
    }

    /**
     * 滑动窗口，l表示左指针，r表示右指针
     * 1.右指针往右滑动直到窗口内的1的个数为k；
     * 2.计算窗口内所有1连续的最小相邻交换次数；
     * 3.左窗口向右滑动直到指向下一个1。
     *
     * @param nums
     * @param k
     * @return
     */
    public static int minMoves(int[] nums, int k) {
        List<Integer> allOneIndex = new ArrayList<>();
        int n = nums.length;
        int ans;
        int count = 0, mid = k / 2;
        for(int i = 0; i < n; i++){
            if(nums[i] == 1){
                allOneIndex.add(i);
            }
        }
        for(int i = 1; i < k; i++){
            count += (allOneIndex.get(i) - allOneIndex.get(i - 1) - 1) * Math.min(i, k - i);
        }
        ans = count;
        for (int i = k; i < allOneIndex.size(); i++) {
            count -= allOneIndex.get(i - k + mid) - allOneIndex.get(i - k);
            count += allOneIndex.get(i) - allOneIndex.get(i - mid);
            ans = Math.min(ans, count);
        }
        return ans;
    }

}


















