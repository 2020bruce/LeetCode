package com.zk.greedy;

public class _1144_DecreaseElementsToMakeArrayZigzag {
    public static void main(String[] args) {
        int[] nums = {10,4,4,10,10,6,2,3};
        int moves = movesToMakeZigzag(nums);
        System.out.println(moves);
    }

    /**
     * 1.先上升,后一个下降是一个很好的选择
     * 2.先下降
     * @param nums
     * @return
     */
    public static int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return 0;
        }else if(n == 2){
            if(nums[0] == nums[1]){
                return 1;
            }else{
                return 0;
            }
        }
        int ans = 0;
        int i = 1;
        int temp = nums[0];
        while(i < n){
            if(nums[i] >= temp){
                ans += Math.abs(nums[i] - temp) + 1;
                temp = nums[i - 1] - 1;
            }else{
                temp = nums[i];
            }
            i++;
            if(i == n){
                break;
            }
            if(nums[i] <= temp){
                ans += Math.abs(nums[i] - temp) + 1;
                temp = nums[i - 1] + 1;
            }else{
                temp = nums[i];
            }
            i++;
        }
        int res = 0;
        i = 1;
        temp = nums[0];
        while(i < n){
            if(nums[i] <= temp){
                res += Math.abs(nums[i] - temp) + 1;
                temp = nums[i - 1] - 1;
            }else{
                temp = nums[i];
            }
            i++;
            if(i == n){
                break;
            }
            if(nums[i] >= temp){
                res += Math.abs(nums[i] - temp) + 1;
                temp = nums[i - 1] + 1;
            }else{
                temp = nums[i];
            }
            i++;
        }
        return Math.min(ans, res);
    }
}
