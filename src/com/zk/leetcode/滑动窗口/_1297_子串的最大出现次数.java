package com.zk.leetcode.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class _1297_子串的最大出现次数 {
    public static void main(String[] args) {
        String s = "aababcaab";
        int maxLetters = 2, minSize =3, maxSize = 4;
        int i = maxFreq(s, maxLetters, minSize, maxSize);
        System.out.println(i);

    }
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<Character, Integer> countCharacter = new HashMap<>();

        //System.out.println(Arrays.toString(letterCount));

        Map<String, Integer> countMap = new HashMap<>();

        int l = 0;
        for(int r = 0; r < s.length(); r++){
            countCharacter.put(s.charAt(r), countCharacter.getOrDefault(s.charAt(r), 0) + 1);

            if(l <= r && r - l + 1 == minSize){
                if(countCharacter.size() <= maxLetters){
                    countMap.put(s.substring(l, r + 1), countMap.getOrDefault(s.substring(l, r + 1), 0) + 1);
                }

                countCharacter.put(s.charAt(l), countCharacter.get(s.charAt(l)) - 1);
                if(countCharacter.get(s.charAt(l)) == 0){
                    countCharacter.remove(s.charAt(l));
                }
                l++;
            }
        }

        int ans = 0;
        for(Map.Entry<String, Integer> entry : countMap.entrySet()){
            //System.out.println(entry.getKey() + " " + entry.getValue());
            if(entry.getValue() > ans){
                ans = entry.getValue();
            }
        }

        return ans;
    }
}











