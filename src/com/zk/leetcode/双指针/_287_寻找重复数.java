package com.zk.leetcode.双指针;

public class _287_寻找重复数 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        int duplicate = findDuplicate(nums);
        System.out.println(duplicate);
    }
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1;
        while(l < r){
            int mid = (l + r) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if(cnt <= mid){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}

































