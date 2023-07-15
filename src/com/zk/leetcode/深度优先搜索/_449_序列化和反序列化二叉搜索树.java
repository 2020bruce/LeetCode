package com.zk.leetcode.深度优先搜索;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _449_序列化和反序列化二叉搜索树 {
    public static void main(String[] args) {
        Object[] root = {};
        TreeNode tree = TreeUtils.createTree(root);
        String s = serialize(tree);
        System.out.println(s);
        TreeNode node = deserialize(s);
        TreeUtils.preOrder(node);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private static void serialize(TreeNode root, StringBuilder builder) {
        if(root == null){
            builder.append("-1 ");
            return;
        }
        int val = root.val;
        builder.append(val + " ");
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        int[] nodes = Arrays.stream(data.split(" ")).mapToInt(Integer::valueOf).toArray();
        Queue<Integer> queue = new LinkedList<>();
        for(int node : nodes){
            queue.offer(node);
        }
        return deserialize(queue);
    }

    private static TreeNode deserialize(Queue<Integer> nodes) {
        if(nodes.size() == 0){
            return null;
        }
        Integer val = nodes.poll();
        if(val == -1){
            return null;
        }
        TreeNode root = new TreeNode(val);
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}
