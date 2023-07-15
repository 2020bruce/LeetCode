package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.List;

public class _133_克隆图 {
    class Node {
        public int val;
        public List<com.zk.leetcode.深度优先搜索._133_克隆图.Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<com.zk.leetcode.深度优先搜索._133_克隆图.Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<com.zk.leetcode.深度优先搜索._133_克隆图.Node>();
        }
        public Node(int _val, ArrayList<com.zk.leetcode.深度优先搜索._133_克隆图.Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static void main(String[] args) {
        
    }
    public static Node cloneGraph(Node node) {

        return null;
    }
}

















































