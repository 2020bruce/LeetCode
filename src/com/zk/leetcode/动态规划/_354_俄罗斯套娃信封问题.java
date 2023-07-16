package com.zk.leetcode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _354_俄罗斯套娃信封问题 {
    public static void main(String[] args) {
        int[][] envelopes = {{6,4},{6,4},{6,7},{2,3}};
        int maxEnvelopes = maxEnvelopesBetter(envelopes);
        System.out.println(maxEnvelopes);
    }

    public static int maxEnvelopesBetter(int[][] envelopes){
        Arrays.sort(envelopes, ((o1, o2) -> {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o2[1] - o1[1];
            }
        }));
        Arrays.stream(envelopes).forEach((o)-> System.out.println(Arrays.toString(o)));
        int n = envelopes.length;
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        for(int i = 1; i < n; i++){
            int num = envelopes[i][1];
            if(num > list.get(list.size() - 1)){
                list.add(num);
            }else{
                int index = binarySearch(list, num);
                list.set(index, num);
            }
        }
        return list.size();
    }

    private static int binarySearch(List<Integer> list, int num) {
        int l = 0, r = list.size();
        while(l < r){
            int mid = (l + r) / 2;
            if(num <= list.get(mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    public static int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, ((o1, o2) -> {
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o2[1] - o1[1];
            }
        }));
        Arrays.stream(envelopes).forEach((o)-> System.out.println(Arrays.toString(o)));
        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i  < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}



























