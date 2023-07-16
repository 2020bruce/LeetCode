package com.zk.leetcode.哈希表;

import java.util.LinkedList;
import java.util.Queue;

public class _433_最小基因变化 {
    public static void main(String[] args) {
        String start = "AACCGGTT", end = "AAACGGTA";
        String[] bank = {"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"};
        int i = minMutation(start, end, bank);
        System.out.println(i);
    }
    public static int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)){
            return 0;
        }
        int ans = 0;
        int n = bank.length;
        Queue<String> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        queue.add(startGene);
        while(queue.size() > 0){
            ans++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String temp = queue.poll();
                for(int j = 0; j < n; j++){
                    if(!isVisited[j] && numOfDifference(temp, bank[j]) == 1){
                        if(bank[j].equals(endGene)){
                            return ans;
                        }
                        isVisited[j] = true;
                        queue.offer(bank[j]);
                    }
                }
            }
        }
        return -1;
    }
    public static int numOfDifference(String s1, String s2){
        char c1[]=s1.toCharArray(),c2[]=s2.toCharArray();
        int count=0;
        for(int i=0;i<c1.length;i++){if(c1[i]!=c2[i]){count++;}}
        return count;
    }
}
