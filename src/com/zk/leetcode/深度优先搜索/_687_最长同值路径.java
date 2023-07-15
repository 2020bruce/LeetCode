package com.zk.leetcode.深度优先搜索;

public class _687_最长同值路径 {
    public static void main(String[] args) {
        Object[] nodes = {5, 5, 4, 4, null, null, null, 4, 4};
        TreeNode root = TreeUtils.createTree(nodes);
        int i = longestUnivaluePath(root);
        System.out.println(i);
    }
    static int ans = 0;
    public static int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    private static int dfs(TreeNode node) {
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int left1 = 0, right1 = 0;
        if(node.left != null && node.val == node.left.val){
            left1 = left + 1;
        }
        if(node.right != null && node.val == node.right.val){
            right1 = right + 1;
        }
        ans = Math.max(ans , left1 + right1);
        return Math.max(left1, right1);
    }
}




























