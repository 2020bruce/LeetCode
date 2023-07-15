package com.zk.leetcode.深度优先搜索;

public class _623_在二叉树中增加一行 {
    public static void main(String[] args) {
        Object[] nodes = {4,2,6,3,1,5};
        int val = 1, depth = 2;
        TreeNode root = TreeUtils.createTree(nodes);
        TreeNode treeNode = addOneRow(root, val, depth);
        TreeUtils.preOrder(treeNode);
    }
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null){
            return null;
        }
        if(depth == 1){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        if(depth == 2){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        }else{
            root.left = addOneRow(root.left, val, depth - 1);
            root.right = addOneRow(root.right, val, depth - 1);
        }
        return root;
    }
}
