package com.zk.leetcode.滑动窗口;

public class _2024_考试的最大困扰度 {
    public static void main(String[] args) {
        String answerKey = "FFFTTFTTFT";
        int k = 3;
        int i = maxConsecutiveAnswers(answerKey, k);
        System.out.println(i);
    }
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    public static int maxConsecutiveChar(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int ans = 0;
        for (int left = 0, right = 0, sum = 0; right < n; right++) {
            sum += answerKey.charAt(right) != ch ? 1 : 0;
            while (sum > k) {
                sum -= answerKey.charAt(left++) != ch ? 1 : 0;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}




































