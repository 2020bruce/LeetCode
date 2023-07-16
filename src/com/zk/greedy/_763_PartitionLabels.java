package com.zk.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _763_PartitionLabels {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> labels = partitionLabels(s);
        labels.forEach(o-> System.out.print(o + " "));
    }

    /**
     * 先统计每个字母的起始位置和结束位置
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int[][] position = new int[26][2];
        for(int i = 0; i < 26; i++){
            Arrays.fill(position[i], -1);
        }

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(position[c - 'a'][0] == -1){
                position[c - 'a'][0] = i;
            }
            position[c - 'a'][1] = i;
        }

        Arrays.sort(position, Comparator.comparingInt(o -> o[0]));

        for(int i = 0; i < 26; i++){
            System.out.println(Arrays.toString(position[i]));
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 26; i++){
            if(position[i][0] == -1){
                continue;
            }
            if(position[i][0] > max){
                ans.add(max - min + 1);
                min = position[i][0];
                max = position[i][1];
            }else if(position[i][1] > max){
                max = position[i][1];
            }
        }
        ans.remove(0);
        ans.add(max - min + 1);
        return ans;
    }
}
