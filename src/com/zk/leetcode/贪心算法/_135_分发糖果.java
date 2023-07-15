package com.zk.leetcode.贪心算法;

public class _135_分发糖果 {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int candy = candy(ratings);
        System.out.println(candy);
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for(int i = 0; i < n; i++){
            if(i > 0 && ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }else{
                left[i] = 1;
            }
        }
        int right = 0, res = 0;
        for(int i = n - 1; i >= 0; i--){
            if(i < n - 1 && ratings[i] > ratings[i + 1]){
                right++;
            }else{
                right = 1;
            }
            res += Math.max(left[i], right);
        }
        return res;
    }

}
