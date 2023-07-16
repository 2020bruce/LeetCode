package com.zk.leetcode.深度优先搜索;

import java.util.HashMap;

public class _662_二叉树最大宽度 {
    public static void main(String[] args) {
        Object[] nodes = {1,3,2,5,null,null,9,6,null,7};
        TreeNode root = TreeUtils.createTree(nodes);
        int width = widthOfBinaryTree(root);
        System.out.println(width);
    }
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    private static int dfs(TreeNode root, int depth, int index) {
        if(root == null){
            return 0;
        }
        map.putIfAbsent(depth, index);
        return Math.max(index - map.get(depth) + 1, Math.max(dfs(root.left, depth + 1, 2 * index), dfs(root.right, depth + 1, 2 * index + 1)));
    }
}
