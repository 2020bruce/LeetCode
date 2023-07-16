package com.zk.leetcode.双指针;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151_反转字符串中的单词 {
    public static void main(String[] args) {
        String s = "the sky say is blue";
        String words = reverseWords(s);
        System.out.println(words);
    }
    public static String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

}


















