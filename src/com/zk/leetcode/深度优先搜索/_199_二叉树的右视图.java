package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_二叉树的右视图 {
    public static void main(String[] args) {
        Object[] nodes = {1,2,3,null,5,null,4};
        TreeNode root = TreeUtils.createTree(nodes);
        List<Integer> list = rightSideView(root);
        for(int i : list){
            System.out.print(i + " ");
        }
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                node =queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            list.add(node.val);

        }

        return list;
    }
}

















