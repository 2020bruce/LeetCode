package com.zk.leetcode.字典树;


import java.util.LinkedList;
import java.util.Queue;

public class TrieST<Value> {
    private static int R = 256;
    private Node root;
    private static class Node{
        Object val;
        Node[] next = new Node[R];
    }
    public Value get(String key){
        Node x = get(root, key, 0);
        if(x == null){
            return null;
        }
        return (Value)x.val;
    }

    private Node get(Node x, String key, int i) {
        if(x == null){
            return null;
        }
        if(i == key.length()){
            return x;
        }
        return get(x.next[key.charAt(i)], key, i + 1);
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int i) {
        if(x == null){
            x = new Node();
        }
        if(i == key.length()){
            x.val = val;
            return x;
        }
        char c = key.charAt(i);
        x.next[c] = put(x.next[c], key, val, i + 1);
        return x;
    }
    public Iterable<String> keysWithPrefix(String s){
        Node node = get(root, s, 0);
        Queue<String> queue = new LinkedList<>();
        collect(node, s, queue);
        return queue;
        
    }

    private void collect(Node x, String pre, Queue<String> queue) {
        if(x == null){
            return;
        }
        if(x.val != null){
            queue.offer(pre);
        }
        for(char c = 0; c < R; c++){
            collect(x.next[c], pre + c, queue);
        }
    }
}






















