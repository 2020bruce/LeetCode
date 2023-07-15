package com.zk.leetcode.双指针;

import java.util.Arrays;

public class _16_最接近的三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        int closest = threeSumClosest(nums, target);
        System.out.println(closest);
    }
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        if(n == 3){
            return Arrays.stream(nums).sum();
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int res = 10000000;
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1, k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return sum;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum > target){
                    int k0 = k - 1;
                    while(j < k0 && nums[k0] == nums[k]){
                        k0--;
                    }
                    k = k0;
                }else{
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }

            }


        }
        return res;
    }
}































