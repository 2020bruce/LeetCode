package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.List;

public class 路径总和Ⅱ_113 {
    public static void main(String[] args) {
        Object[] nodes = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = TreeUtils.createTree(nodes);
        int targetSum = 22;
        List<List<Integer>> list = pathSum(root, targetSum);
        for(List<Integer> path : list){
            for(Integer i : path){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
    static List<List<Integer>> lists = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return lists;
    }

    private static void dfs(TreeNode root, int targetSum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                list.add(root.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);
        if(root.left != null){
            dfs(root.left, targetSum - root.val);
        }
        if(root.right != null){
            dfs(root.right, targetSum - root.val);
        }
        list.remove(list.size() - 1);
    }
}















