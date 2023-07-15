package com.zk.leetcode.字典树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _648_单词替换 {
    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        String s = replaceWords(dictionary, sentence);
        System.out.println(s);
    }

    /**
     * 1.先把sentence中的每个单词分割出来，把每个单词的每个字母进行字典树的插入；
     * 2.循环遍历dictionary
     * @param dictionary
     * @param sentence
     * @return
     */
    public static String replaceWords(List<String> dictionary, String sentence) {
        dictionary.sort((a, b)->b.length() - a.length());
        Trie trie = new Trie();
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            trie.put(words[i], i);
        }
        String[] ans = words;
        for(String dic : dictionary){
            List<Integer> list = trie.get(dic);
            if(list == null){
                continue;
            }
            for(int i : list){
                ans[i] = dic;
            }
        }
        return Arrays.stream(ans).reduce((a, b) -> a + " " + b).orElse(" ");
    }
}

class Trie{
    private static int R = 26;
    private Node root;
    private static class Node{
        List<Integer> position = new ArrayList<>();
        Node[] next = new Node[R];
    }

    public void put(String word, int value){
        root = put(root, word, value, 0);
    }

    private Node put(Node x, String word, int value, int i) {
        if(x == null){
            x = new Node();
        }
        int n = word.length();
        x.position.add(value);
        if(i == n){
            return x;
        }
        char letter = word.charAt(i);
        x.next[letter - 'a'] = put(x.next[letter - 'a'], word, value, i + 1);
        return x;
    }

    public List<Integer> get(String word){
        Node x = get(root, word, 0);
        if(x == null){
            return null;
        }
        return x.position;
    }

    private Node get(Node x, String word, int i) {
        if(x == null){
            return null;
        }
        if(i == word.length()){
            return x;
        }
        return get(x.next[word.charAt(i) - 'a'], word, i + 1);
    }

}





















