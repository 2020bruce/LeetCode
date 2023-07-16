package com.zk.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _1262_GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        int[] nums = {2,6,2,2,7};
        int maxSumDivThree = maxSumDivThree(nums);
        System.out.println(maxSumDivThree);
    }

    public static int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        for(int num : nums){
            sum += num;
            if(num % 3 == 1){
                one.add(num);
            }else if(num % 3 == 2){
                two.add(num);
            }
        }
        int oneSize = one.size(), twoSize = two.size();
        if(n - oneSize - twoSize == 0){
            if((oneSize < 3 && twoSize == 0) || (oneSize == 0 && twoSize < 3)){
                return 0;
            }
        }
        if(twoSize == oneSize){
            return sum;
        }
        int remainderOne = oneSize % 3;
        int remainderTwo = twoSize % 3;
        if(remainderOne > remainderTwo){
            ans = getAns(sum, ans, one, two, twoSize, remainderOne, remainderTwo);

        }else{
            ans = getAns(sum, ans, two, one, oneSize, remainderTwo, remainderOne);
        }

        return ans;
    }

    private static int getAns(int sum, int ans, List<Integer> one, List<Integer> two, int twoSize, int remainderOne, int remainderTwo) {
        int t1 = sum , t2 = sum;
        for(int i = 0; i < remainderOne - remainderTwo; i++){
            t1 -= one.get(i);
        }
        if(twoSize >= 3){
            for(int i = 0; i < 3 - remainderOne + remainderTwo; i++){
                t2 -= two.get(i);
            }
            ans = Math.max(t1, t2);
        }
        ans = Math.max(ans, t1);
        return ans;
    }
}
