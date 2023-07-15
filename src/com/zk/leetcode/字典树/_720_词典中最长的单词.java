package com.zk.leetcode.字典树;

public class _720_词典中最长的单词 {
    public static void main(String[] args) {
        // String[] words = {"w","wo","wor","worl", "world"};
        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        String s = longestWord(words);
        System.out.println(s);
    }
    public static String longestWord(String[] words) {
        Trie_720 trie = new Trie_720();
        for(String word : words){
            trie.put(word);
        }
        String ans = "";
        for(String word : words){
            boolean isAns = trie.get(word);
            if(isAns && (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0))){
                ans = word;
            }
        }
        return ans;
    }
}

class Trie_720{
    private static int R = 26;
    private static Node root;
    private static class Node{
        private Node[] next = new Node[R];
        private boolean isEnd;
    }

    public void put(String word){
        root = put(root, word, 0);
    }

    private Node put(Node x, String word, int i) {
        if(x == null){
            x = new Node();
        }
        int n = word.length();
        if(i == n){
            x.isEnd = true;
            return x;
        }
        x.next[word.charAt(i) - 'a'] = put(x.next[word.charAt(i) - 'a'], word, i + 1);
        return x;
    }

    /**
     * 判断word中每个字母是否都在字典树中，若全在字典树中则返回true，否则返回false
     * @param word
     * @return
     */
    boolean flag;
    public boolean get(String word){
        flag = false;
        get(root, word, 0);
        return flag;
    }

    private void get(Node x, String word, int i) {
        if(x == null){
            return;
        }
        int n = word.length();
        if(i == n && x.isEnd){
            flag = true;
            return;
        }
        if(x == root || x.isEnd){
            get(x.next[word.charAt(i) - 'a'], word, i + 1);
        }

    }
}



















































