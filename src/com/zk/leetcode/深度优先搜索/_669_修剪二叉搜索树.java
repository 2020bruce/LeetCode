package com.zk.leetcode.深度优先搜索;

public class _669_修剪二叉搜索树 {
    public static void main(String[] args) {
        Object[] nodes = {3,2,4,1};
        TreeNode root = TreeUtils.createTree(nodes);
        int low = 1, high = 1;
        TreeNode bst = trimBST(root, low, high);
        TreeUtils.preOrder(bst);
    }
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode tree = preOrder(root, low, high);
        return tree;
    }
    public static TreeNode preOrder(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val < low){
            return preOrder(root.right, low, high);
        }else if(root.val > high){
            return preOrder(root.left, low, high);
        }
        root.left = preOrder(root.left, low, high);
        root.right = preOrder(root.right, low, high);

        return root;
    }

}
