package com.zk.leetcode.深度优先搜索;

public class _98_验证二叉搜索树 {
    public static void main(String[] args) {
        Object[] root = {5,4,6,null,null,3,7};
        TreeNode tree = TreeUtils.createTree(root);
        boolean b = isValidBST(tree);
        System.out.println(b);
    }
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public static boolean isValidBST(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}



















