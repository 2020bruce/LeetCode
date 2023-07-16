package com.zk.leetcode.字典树;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _472_连接词 {
    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> list = findAllConcatenatedWordsInADict(words);
        list.forEach(o-> System.out.println(o + " "));
    }

    /**
     * 1.将字符串数组按字符串长度排序；
     * 2.将每个词构建字典树；
     * 3.遍历每个词，截取该词的一部分，若字典树中存在该单词则进行深度优先遍历；
     * 4.若字典中存在前面一段单词，则后面的单词进行深度优先遍历；
     * 5.
     *
     * @param words
     * @return
     */
    static Trie_472 trie = new Trie_472();
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        trie.root.isEnd = true;
        int n = words.length;
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for(int i = 0; i < n; i++){
            String word = words[i];
            if(dfs(word, 0)){
                ans.add(word);
            }else{
                trie.insert(word);
            }
        }
        return ans;
    }

    private static boolean dfs(String word, int start) {
        if(word.length() == start){
            return true;
        }
        Trie_472.Node node = trie.root;
        for(int i = start; i < word.length(); i++){
            char c = word.charAt(i);
            node = node.next[c - 'a'];
            if(node == null){
                return false;
            }
            if(node.isEnd){
                if(dfs(word, i + 1)){
                    return true;
                }
            }
        }
        return false;
    }
}

class Trie_472{
    public Node root = new Node();
    private final int R = 26;
    public class Node{
        public Node[] next = new Node[R];
        public boolean isEnd;
    }
    public void insert(String word){
        root = insert(root, word, 0);
    }

    private Node insert(Node x, String word, int index) {
        if(x == null){
            x = new Node();
        }
        if(word.length() == index){
            x.isEnd = true;
            return x;
        }
        x.next[word.charAt(index) - 'a'] = insert(x.next[word.charAt(index) - 'a'], word, index + 1);
        return x;
    }

    public boolean get(String word){
        Node x = get(root, word, 0);
        return x != null;
    }

    private Node get(Node x, String word, int index) {
        if(x == null){
            return null;
        }
        if(word.length() == index){
            return x;
        }
        return get(x.next[word.charAt(index) - 'a'], word, index + 1);
    }
}




































