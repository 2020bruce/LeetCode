package com.zk.leetcode.深度优先搜索;

import java.util.*;

public class _508_出现次数最多的子树元素和 {
    public static void main(String[] args) {
        Object[] arr = {5,2,-5};
        TreeNode root = TreeUtils.createTree(arr);
        int[] sum = findFrequentTreeSum(root);
        System.out.println(Arrays.toString(sum));
    }

    static HashMap<Integer, Integer> map = new HashMap<>();
    static int maxCnt = 0;
    public static int[] findFrequentTreeSum(TreeNode root) {
        preOrder(root);
        int n = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int c = entry.getValue();
            if (c == maxCnt) {
                n++;
            }
        }
        int[] res = new int[n];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int c = entry.getKey(), s = entry.getValue();
            if (s == maxCnt) {
                res[index++] = c;
            }
        }
        return res;
    }

    public static int preOrder(TreeNode node){
        if(node == null){
            return 0;
        }
        int root = node.val;
        int left = 0, right = 0;
        if(node.left != null){
            left = preOrder(node.left);
        }
        if(node.right != null){
            right = preOrder(node.right);
        }
        int sum = root + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxCnt = Math.max(maxCnt, map.get(sum));
        return sum;
    }

}
