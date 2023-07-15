package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _515_在每个树行中找最大值 {
    public static void main(String[] args) {
        Object[] root = {1,3,2,5,3,null,9};
        TreeNode tree = TreeUtils.createTree(root);
        List<Integer> list = largestValues(tree);
        for(int val : list){
            System.out.print(val + " ");
        }
    }

    static HashMap<Integer, Integer> map = new HashMap<>();
    static List<Integer> ans;
    public static List<Integer> largestValues(TreeNode root) {
        int depth = 0;
        preOrder(root, depth);
        ans = new ArrayList<>(map.values());
        return ans;
    }

    private static void preOrder(TreeNode root, int depth) {
        if(root == null){
            return;
        }
        int val = root.val;
        if(map.containsKey(depth)){
            int old = map.get(depth);
            if(val > old){
                map.put(depth, val);
            }
        }else{
            map.put(depth, val);
        }

        preOrder(root.left, depth + 1);
        preOrder(root.right, depth + 1);

    }
}

















