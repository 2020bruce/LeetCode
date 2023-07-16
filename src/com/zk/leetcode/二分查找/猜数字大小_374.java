package com.zk.leetcode.二分查找;

public class 猜数字大小_374 {
    public static void main(String[] args) {

    }
    public int guessNumber(int n) {
        int l = 1, r = n;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(guess(mid) <= 0){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;

    }

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    private int guess(int num) {
        return 0;
    }
}
