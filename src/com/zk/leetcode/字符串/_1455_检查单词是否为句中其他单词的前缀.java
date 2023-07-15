package com.zk.leetcode.字符串;

public class _1455_检查单词是否为句中其他单词的前缀 {
    public static void main(String[] args) {
        String sentence = "this problem is an easy problem", searchWord = "pro";
        int i = isPrefixOfWord(sentence, searchWord);
        System.out.println(i);
    }
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int m = searchWord.length();
        int res = -1;
        for(int k = 0; k < words.length; k++){
            int n = words[k].length();
            int i = 0;
            int j = 0;
            while(i < n && j < m){
                if(words[k].charAt(i) != searchWord.charAt(j)){
                    break;
                }else{
                    i++;
                    j++;
                }
            }
            if(j == m){
                res = k + 1;
                break;
            }
        }
        return res;
    }

}












