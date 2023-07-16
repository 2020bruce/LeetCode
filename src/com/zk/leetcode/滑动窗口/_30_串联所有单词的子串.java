package com.zk.leetcode.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _30_串联所有单词的子串 {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> list = findSubstring(s, words);
        list.forEach(o-> System.out.print(o + " "));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int m = words.length, n = words[0].length();
        int ls = s.length();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            HashMap<String, Integer> map = new HashMap<>();
            if(i > ls - m * n){
                break;
            }
            for(int j = 0; j < m; j++){
                String temp = s.substring(i + j * n, i + (j + 1) * n);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            for(String word : words){
                map.put(word, map.getOrDefault(word, 0) - 1);
                if(map.get(word) == 0){
                    map.remove(word);
                }
            }
            for(int j = i; j < ls - m * n + 1; j += n){
                if(j != i){
                    String word = s.substring(j + (m - 1) * n, j + m * n);
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    if(map.get(word) == 0){
                        map.remove(word);
                    }

                    word = s.substring(j - n, j);
                    map.put(word, map.getOrDefault(word, 0) - 1);

                    if(map.get(word) == 0){
                        map.remove(word);
                    }

                }
                if(map.isEmpty()){
                    ans.add(j);
                }
            }
        }
        return ans;
    }
}






















