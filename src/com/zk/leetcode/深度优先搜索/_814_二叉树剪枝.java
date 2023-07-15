package com.zk.leetcode.深度优先搜索;

public class _814_二叉树剪枝 {
    public static void main(String[] args) {
        Object[] root = {1,null,0,0,1};
        TreeNode tree = TreeUtils.createTree(root);
        TreeNode treeNode = pruneTree(tree);
        TreeUtils.preOrder(treeNode);
    }
    public static TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }
}
