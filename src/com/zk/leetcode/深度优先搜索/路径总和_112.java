package com.zk.leetcode.深度优先搜索;

import java.util.Stack;

public class 路径总和_112 {
    public static void main(String[] args) {
        Object[] arr = {1,-2,-3,1,3,-2,null,-1};
        TreeNode node = TreeUtils.createTree(arr);
        boolean b = hasPathSum(node, 3);
        System.out.println(b);
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(root.val);


        TreeNode node = null;
        int v = 0;
        while(!stack.isEmpty()){
            node = stack.pop();
            v = value.pop();

            if(node.left == null && node.right == null){
                if(v == targetSum){
                    return true;
                }
                continue;
            }
            if(node.right != null){
                stack.push(node.right);
                value.push(node.right.val + v);
            }
            if(node.left != null){
                stack.push(node.left);
                value.push(node.left.val + v);
            }


        }


        return false;
    }


}
