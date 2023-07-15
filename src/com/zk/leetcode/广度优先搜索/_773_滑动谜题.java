package com.zk.leetcode.广度优先搜索;

import java.util.*;

public class _773_滑动谜题 {
    public static void main(String[] args) {
        int[][] board = {{1,2,3},{4,0,5}};
        int slidingPuzzle = slidingPuzzle(board);
        System.out.println(slidingPuzzle);
    }

    /**
     * 1.让0的滑块进行广度优先遍历，每次与相邻的滑块进行替换；
     * 2.替换之后再判断此时的棋盘是否满足‘123450’情况；
     * 3.每次替换之后都记录这次交换后的棋盘，若这次棋盘没有见过则可以进行替换；
     * @param board 2 * 3
     * @return
     */
    static int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    public static int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++){
                sb.append(board[i][j]);
            }
        }
        if(sb.toString().equals("123450")){
            return 0;
        }
        String init = sb.toString();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(init);
        int step = 0;
        Set<String> seen = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++){
                String poll = queue.poll();
                assert poll != null;
                for(String next : nextStep(poll)){
                    if(!seen.contains(next)){
                        if(next.equals("123450")){
                            return step;
                        }
                        queue.offer(next);
                        seen.add(next);
                    }

                }
            }
        }


        return -1;
    }

    private static List<String> nextStep(String poll) {
        char[] array = poll.toCharArray();
        int index = poll.indexOf('0');
        List<String> nextStep = new ArrayList<>();
        for(int neighbor : neighbors[index]){
            swap(array, index, neighbor);
            nextStep.add(new String(array));
            swap(array, index, neighbor);
        }
        return nextStep;
    }

    private static void swap(char[] array, int index, int neighbor) {
        char temp = array[index];
        array[index] = array[neighbor];
        array[neighbor] = temp;
    }
}




































