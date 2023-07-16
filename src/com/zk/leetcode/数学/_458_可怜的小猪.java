package com.zk.leetcode.数学;

public class _458_可怜的小猪 {
    public static void main(String[] args) {
        int buckets = 1000, minutesToDie = 15, minutesToTest = 60;
        int i = poorPigs(buckets, minutesToDie, minutesToTest);
        System.out.println(i);
    }
    //(⌊minutesToTest / minutesToDie⌋ + 1)^pigs（状态数） ≥ buckets（桶数）  每种猪的组合状态都可以表示一个桶中的水是否有毒
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return (int)(Math.ceil(Math.log(buckets) / Math.log(minutesToTest / minutesToDie + 1)));
    }
}
