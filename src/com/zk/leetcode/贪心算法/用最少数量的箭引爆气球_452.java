package com.zk.leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class 用最少数量的箭引爆气球_452 {
    public static void main(String[] args) {
        int[][] points = {
                {28512,37316},
                {84288,95091},
                {-42461,74401},
                {-79704,-48690},
                {-98214,-79133},
                {-9879,72447},
                {-31051,48380},
                {-48251,63441},
                {-73839,82201},
                {670,17678},
                {-49178,79180},
                {-51097,-20129},
                {25207,55302},
                {50489,83618},
                {-41955,-24615},
                {-17674,44574},
                {-53950,96644},
                {60417,89225}
        };
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n == 1){
            return 1;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for(int[] arr : points){
            System.out.println(Arrays.toString(arr));
        }
        int shot = 1;
        int max = points[0][1];
        for(int i = 1; i < n; i++){
            if(points[i][0] > max){
                shot++;
                max = points[i][1];
            }

        }
        return shot;

    }
}
