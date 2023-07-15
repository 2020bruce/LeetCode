package com.zk.leetcode.深度优先搜索;

public class _513_找树左下角的值 {
    public static void main(String[] args) {
        Object[] nodes = {1,2,3,4,null,5,6,null,null,7};
        TreeNode root = TreeUtils.createTree(nodes);
        int bottomLeftValue = findBottomLeftValue(root);
        System.out.println(bottomLeftValue);
    }
    static int ans;
    public static int findBottomLeftValue(TreeNode root) {
        int deep = treeDeep(root);
        dfs(root, deep, 1);
        return ans;
    }
    private static void dfs(TreeNode root, int deep, int h) {
        if(root == null){
            return;
        }
        if(deep == h){
            ans = root.val;
            return;
        }
        dfs(root.right, deep, h + 1);
        dfs(root.left, deep, h + 1);

    }

    private static int treeDeep(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(treeDeep(root.left), treeDeep(root.right)) + 1;
    }
}
