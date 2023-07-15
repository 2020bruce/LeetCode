package com.zk.leetcode.哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _554_砖墙 {
    public static void main(String[] args) {
        int[][] wall = {{1},{1},{1}};
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < wall.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < wall[i].length; j++){
                list.add(wall[i][j]);
            }
            lists.add(list);
        }
        int i = leastBricks(lists);
        System.out.println(i);
    }
    public static int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int sum = 0;
            int m = wall.get(i).size();
            for(int j = 0; j < m - 1; j++){
                sum += wall.get(i).get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        return wall.size() - max;
    }
}































































