package com.zk.leetcode.字典树;

public class _208_实现Trie前缀树 {
    private static int R = 256;
    private Node root;
    private static class Node{
        Object val;
        Node[] next = new Node[256];
    }
    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node x, String word, int i) {
        if(x == null){
            x = new Node();
        }
        if(i == word.length()){
            x.val = 1;
            return x;
        }
        char c = word.charAt(i);
        x.next[c] = insert(x.next[c], word, i + 1);
        return x;

    }

    public boolean search(String word) {
        Node x = search(root, word, 0);
        if(x == null || x.val == null){
            return false;
        }else{
            return true;
        }
    }

    private Node search(Node x, String word, int i) {
        if(x == null){
            return null;
        }
        if(i == word.length()){
            return x;
        }
        char c = word.charAt(i);
        return search(x.next[c], word, i + 1);
    }

    public boolean startsWith(String prefix) {
        Node x = search(root, prefix, 0);
        return collect(x, prefix);

    }

    private boolean collect(Node x, String prefix) {
        if(x == null){
            return false;
        }else if((int)x.val == 1){
            return true;
        }

        for(char c = 0; c < R; c++){
            if(x.next[c] != null){
                return true;
            }
        }
        return false;
    }
}












