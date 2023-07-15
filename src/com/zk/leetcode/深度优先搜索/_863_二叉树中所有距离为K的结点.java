package com.zk.leetcode.深度优先搜索;

import java.util.*;

public class _863_二叉树中所有距离为K的结点 {
    public static void main(String[] args) {
        Object[] nodes = {0,null,1,null,2,null,3};
        TreeNode root = TreeUtils.createTree(nodes);
        TreeNode target = new TreeNode(1);
        int k = 2;
        List<Integer> list = distanceK(root, target, k);
        list.forEach((o)-> System.out.print(o + " "));
    }

    /**
     * 1.用先序遍历先找到所有节点的父节点；
     * 2.从目标节点使用层次遍历，记录距离为k的所有节点的值；
     * 3.从目标节点的父节点开始使用层次遍历，记录距离为k的所有节点的值；
     * 4.返回步骤2和步骤3中记录的节点的值。
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    static Map<TreeNode, TreeNode> father = new HashMap<>();
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 为每个节点添加父节点
        recordFather(root, null);
//        for(Map.Entry<TreeNode, TreeNode> entry : father.entrySet()){
//            System.out.println("child:" + entry.getKey().val + " " + "father:" + entry.getValue().val);
//        }
        // 找到target节点
        target = findTarget(root, target.val);
        // 从target节点开始寻找距离为k的节点
        TreeNode cur = target;
        List<Integer> ans = new ArrayList<>(findDistanceK(cur, k--));
        while(father.containsKey(cur)){
            TreeNode parent = father.get(cur);
            if(parent.left == cur){
                parent.left = null;
            }else{
                parent.right = null;
            }
            cur = parent;
            ans.addAll(findDistanceK(cur, k--));
        }

        return ans;
    }

    private static List<Integer> findDistanceK(TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(target);
        int deep = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
                if(deep == k){
                    ans.add(poll.val);
                }
            }
            deep++;
        }

        return ans;
    }

    /**
     * 找到target节点位置
     * @param root
     * @param val
     * @return
     */
    private static TreeNode findTarget(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur == null){
                continue;
            }
            if(cur.val == val){
                return cur;
            }
            stack.push(cur.right);
            stack.push(cur.left);
        }
        return root;
    }

    /**
     * 记录每个节点的父节点
     * @param node
     * @param parent
     */
    private static void recordFather(TreeNode node, TreeNode parent) {
        if(node == null){
            return;
        }
        if(parent != null){
            father.put(node, parent);
        }
        recordFather(node.left, node);
        recordFather(node.right, node);
    }
}




























