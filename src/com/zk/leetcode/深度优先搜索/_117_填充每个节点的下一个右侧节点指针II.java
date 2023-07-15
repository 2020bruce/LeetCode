package com.zk.leetcode.深度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

public class _117_填充每个节点的下一个右侧节点指针II {

    public static void main(String[] args) {
        Object[] root = {1,2,3,4,5,null,7};
        Node treeNode = createTree(root);
        Node node = connect(treeNode);
        System.out.println(node.next);

    }

    public static Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //每一层节点数量
            int size = queue.size();
            //前一个节点
            Node pre = null;
            for(int i = 0;i < size; i++){
                Node cur = queue.poll();
                if(pre != null){
                    pre.next = cur;
                }
                pre = cur;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    public static Node createTree(Object[] arr){
        if(arr.length == 0){
            return null;
        }
        Queue<Node> queue = new LinkedList();
        Node root = new Node((int)arr[0]);
        queue.offer(root);

        int i = 1;
        Node node = null;
        while(!queue.isEmpty() && i < arr.length){
            if(queue.peek() != null){
                node = queue.poll();
                if(arr[i] == null){
                    node.left = null;
                    i++;
                }else{
                    node.left = new Node((int)arr[i++]);
                    queue.offer(node.left);
                }
                if(i == arr.length){
                    break;
                }
                if(arr[i] == null){
                    node.right = null;
                    i++;
                }else{
                    node.right = new Node((int)arr[i++]);
                    queue.offer(node.right);
                }
            }

        }
        return root;
    }

}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}










































