package com.zk.leetcode.深度优先搜索;

import java.util.*;

public class _652_寻找重复的子树 {
    public static void main(String[] args) {
        Object[] root = {1,2,3,4,null,2,4,null,null,4};
        TreeNode node = TreeUtils.createTree(root);
        List<TreeNode> duplicateSubtrees = findDuplicateSubtrees(node);
        for(TreeNode treeNode : duplicateSubtrees){
            System.out.println(treeNode + " ");
        }
    }


    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        return null;
    }

    public static String dfs(TreeNode node) {
        return null;
    }
}
