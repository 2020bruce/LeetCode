package com.zk.leetcode.数学;

import java.util.Arrays;

public class _1979_找出数组的最大公约数 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,9,10};
        int gcd = findGCD(nums);
        System.out.println(gcd);
    }

    public static int findGCD(int[] nums) {
        int min = Arrays.stream(nums).min().orElse(Integer.MIN_VALUE);
        int max = Arrays.stream(nums).max().orElse(Integer.MAX_VALUE);
        return gcd(min, max);
    }

    public static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}






























