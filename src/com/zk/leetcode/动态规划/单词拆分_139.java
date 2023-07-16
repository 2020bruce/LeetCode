package com.zk.leetcode.动态规划;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 单词拆分_139 {
    public static void main(String[] args) {
        List<String> wordDice = new ArrayList<>();
        Collections.addAll(wordDice, "cats", "dog", "sand", "and", "cat");
        String s = "catsandog";
        boolean b = wordBreakBest(s, wordDice);
        System.out.println(b);
    }
    //改进版本
    public static boolean wordBreakBest(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++){
            if(dp[i]){
                for(String word : wordDict){
                    if(word.length() <= n - i && s.startsWith(word, i)){
                        dp[i + word.length()] = true;
                    }
                }
            }
        }
        return dp[n];
    }

    //第一版本，比较老旧
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n];
        List<Integer> t = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(t.size() == 0){
                if(wordDict.contains(s.charAt(i)) || wordDict.contains(s.substring(0, i + 1))){
                    dp[i] = true;
                    t.add(i);
                }
            }else{
                for(int j : t){
                    if(wordDict.contains(s.charAt(i)) ||
                            wordDict.contains(s.substring(0, i + 1)) ||
                            wordDict.contains(s.substring(j + 1, i + 1))){
                        dp[i] = true;
                        t.add(i);
                        break;
                    }
                }
            }

        }
        return dp[n - 1];
    }
}
