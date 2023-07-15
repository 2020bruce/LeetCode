package com.zk.leetcode.深度优先搜索;

public class _565_数组嵌套 {
    public static void main(String[] args) {
        int[] A = {5,4,0,3,1,6,2};
        int i = arrayNesting(A);
        System.out.println(i);
    }
    public static int arrayNesting(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int cnt = 0;
            while(nums[i] < n){
                int num = nums[i];
                nums[i] = n;
                i = num;
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
