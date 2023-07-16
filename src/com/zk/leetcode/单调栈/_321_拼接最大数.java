package com.zk.leetcode.单调栈;

import java.util.Arrays;

public class _321_拼接最大数 {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] number = maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(number));
    }
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int start = Math.max(0, k - n), end = Math.min(k, m);
        int[] maxSubsequence = new int[k];
        for(int i = start; i <= end; i++){
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if(compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0){
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
            }

        }
        return maxSubsequence;
    }

    private static int[] merge(int[] subsequence1, int[] subsequence2) {
        int m = subsequence1.length, n = subsequence2.length;
        int[] curMaxSubsequence = new int[m + n];
        int idx1 = 0, idx2 = 0;
        for(int i = 0; i < m + n; i++){
            if(compare(subsequence1, idx1, subsequence2, idx2) > 0){
                curMaxSubsequence[i] = subsequence1[idx1++];
            }else{
                curMaxSubsequence[i] = subsequence2[idx2++];
            }
        }
        return curMaxSubsequence;
    }

    private static int compare(int[] subsequence1, int idx1, int[] subsequence2, int idx2) {
        int m = subsequence1.length, n = subsequence2.length;
        while(idx1 < m && idx2 < n){
            int difference = subsequence1[idx1] - subsequence2[idx2];
            if(difference != 0){
                return difference;
            }
            idx1++;
            idx2++;
        }
        return (m - idx1) - (n - idx2);
    }

    private static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int remain = n - k;
        int[] stack = new int[k];
        int top = -1;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            while(top >= 0 && remain > 0 && num > stack[top]){
                top--;
                remain--;
            }
            if(top < k - 1){
                stack[++top] = num;
            }else{
                remain--;
            }
        }
        return stack;
    }
}






















