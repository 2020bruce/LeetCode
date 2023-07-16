package com.zk.leetcode.滑动窗口;

import java.util.Arrays;

public class _719_找出第K小的数对距离 {
    public static void main(String[] args) {
        int[] nums = {62,100,4};
        int k = 2;
        int pair = smallestDistancePair(nums, k);
        System.out.println(pair);
    }

    /**
     * 1.数组进行排序
     * 2.限制出数对距离的取值范围，使用二分法查找
     * (*)3.二分法查找出小于等于该数对距离的数对个数:
     *      1)右指针不断向右移动，左指针移动到右值-左值小于等于数对距离
     *      2)sum += right - left;
     *      3)sum值即为小于等于该数对距离的数对个数
     * 4.找到刚好sum>=K的位置即为第K小的数对距离
     * @param nums
     * @param k
     * @return
     */
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1] - nums[0];
        while(l < r){
            int mid = (l + r) / 2;
            int sum = 0;
            int left = 0, right = 0;
            while(right < n){
                if(nums[right] - nums[left] <= mid){
                    sum += right - left;
                    right++;
                }else{
                    left++;
                }
            }
            if(sum < k){
                l = mid + 1;
            }else{
                r = mid;
            }

        }
        return l;
    }
}













