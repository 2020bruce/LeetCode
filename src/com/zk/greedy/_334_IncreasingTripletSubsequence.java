package com.zk.greedy;

public class _334_IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {5,1,6};
        boolean triplet = increasingTriplet(nums);
        System.out.println(triplet);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int first = nums[0], second = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++){
            if(nums[i] > second){
                return true;
            }else{
                if(nums[i] > first){
                    second = nums[i];
                }else{
                    first = nums[i];
                }
            }
        }
        return false;
    }
}























