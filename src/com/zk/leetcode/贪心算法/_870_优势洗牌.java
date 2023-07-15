package com.zk.leetcode.贪心算法;

import java.util.Arrays;

public class _870_优势洗牌 {

    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15}, nums2 = {1,10,4,11};
        int[] ints = advantageCount(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Integer[] index1 = new Integer[n];
        Integer[] index2 = new Integer[n];
        for(int i = 0; i < n; i++){
            index1[i] = i;
            index2[i] = i;
        }

        Arrays.sort(index1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(index2, (i, j) -> nums2[i] - nums2[j]);

        System.out.println(Arrays.toString(index1));
        System.out.println(Arrays.toString(index2));

        int left = 0, right = n - 1;
        for(int i = 0; i < n; i++){
            if(nums1[index1[i]] > nums2[index2[left]]){
                res[index2[left]] = nums1[index1[i]];
                left++;
            }else{
                res[index2[right]] = nums1[index1[i]];
                right--;
            }
        }

        return res;
    }
}



























































