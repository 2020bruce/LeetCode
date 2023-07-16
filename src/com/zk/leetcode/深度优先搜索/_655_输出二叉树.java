package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.List;

public class _655_输出二叉树 {
    public static void main(String[] args) {
        Object[] nodes = {1,2};
        TreeNode root = TreeUtils.createTree(nodes);
        List<List<String>> lists = printTree(root);
        for(List<String> list : lists){
            for(String s : list){
                System.out.print(s + " ");
            }
            System.out.println();
        }

    }

    static List<List<String>> lists = new ArrayList<>();
    public static List<List<String>> printTree(TreeNode root) {
        if(root == null){
            return null;
        }
        int height = TreeUtils.depth(root) - 1;
        System.out.println(height);
        int m = height + 1;
        int n = (int)Math.pow(2, height + 1) - 1;

        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<String>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            lists.add(list);
        }
        dfs(root, 0, (n-1)/2, height);
        return lists;
    }

    private static void dfs(TreeNode node, int r, int c, int height) {
        if(node == null){
            return;
        }else{
            lists.get(r).set(c, node.val + "");
        }
        dfs(node.left, r + 1, c - (int) Math.pow(2, height - r - 1), height);
        dfs(node.right, r + 1, c + (int) Math.pow(2, height - r - 1), height);
    }

}










