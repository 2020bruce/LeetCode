package com.zk.twoPointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _524_LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale", "abe", "apple", "monkey", "plea");
        String longestWord = findLongestWord(s, dictionary);
        System.out.println(longestWord);
    }
    public static String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            if(o1.length() != o2.length()){
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });
        for(String dic : dictionary){
            for(int i = 0, j = 0; i < s.length(); i++){
                if(s.charAt(i) == dic.charAt(j)){
                    j++;
                }
                if(j == dic.length()){
                    return dic;
                }
            }
        }
        return "";
    }
}
