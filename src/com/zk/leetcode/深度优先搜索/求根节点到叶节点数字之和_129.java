package com.zk.leetcode.深度优先搜索;

public class 求根节点到叶节点数字之和_129 {
    public static void main(String[] args) {
        Object[] nodes = {1, 2, 3};
        TreeNode root = TreeUtils.createTree(nodes);
        int i = sumNumbers(root);
        System.out.println(i);
    }
    static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    private static void dfs(TreeNode node, int preSum){
        int num = preSum * 10 + node.val;
        if(node.left == null && node.right == null){
            sum += num;

            return;
        }

        if(node.left != null){
            dfs(node.left, num);

        }
        if(node.right != null){
            dfs(node.right, num);

        }
    }
}














