package com.zk.leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;

public class _447_回旋镖的数量 {
    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        int i = numberOfBoomerangs(points);
        System.out.println(i);
    }
    public static int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++){
                int distant = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.put(distant, map.getOrDefault(distant, 0) + 1);
            }
            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
                int t = entry.getValue();
                count += t * (t - 1);
            }

        }
        return count;
    }
}
