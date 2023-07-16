package com.zk.leetcode.双指针;

import java.util.Arrays;

public class _948_令牌放置 {
    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        int power = 200;
        int score = bagOfTokensScore(tokens, power);
        System.out.println(score);
    }

    /**
     * l表示左指针，r表示右指针，指向使用了令牌的下一个令牌。
     * 1.l一直往右滑动直到power-tokens[l]<0,r往左滑动一个；
     * @param tokens
     * @param power
     * @return
     */
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length;
        int l = 0, r = n - 1;
        int scores = 0;
        while(l <= r){
            while(l <= r && power - tokens[l] >= 0){
                power -= tokens[l++];
                scores++;
            }
            if(l < r && scores > 0){
                power += tokens[r--];
                scores--;
            }else{
                break;
            }
        }
        return scores;
    }
}




















