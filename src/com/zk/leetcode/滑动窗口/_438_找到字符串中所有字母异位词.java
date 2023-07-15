package com.zk.leetcode.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _438_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> anagrams = findAnagramsBetter(s, p);
        System.out.println(anagrams);
    }

    public static List<Integer> findAnagramsBetter(String s, String p){
        List<Integer> res = new ArrayList<>();
        int m = s.length(), n = p.length();
        int[] count = new int[26];
        for(int i = 0; i < n; i++){
            count[p.charAt(i) - 'a']++;
        }
        //System.out.println(Arrays.toString(count));
        int lo = 0, hi = 0;
        while(hi < m){
            if(count[s.charAt(hi) - 'a'] > 0){
                count[s.charAt(hi) - 'a']--;
                hi++;
                if(hi - lo == n){
                    res.add(lo);
                }
            }else{
                count[s.charAt(lo) - 'a']++;
                lo++;
            }
        }
        return res;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length(), n = p.length();
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int begin = 0, end = n - 1;
        Arrays.sort(pc);
        for(; end < m; end++, begin++){
            boolean b = isAnagram(s.substring(begin, end + 1).toCharArray(), pc);
            if(b){
                res.add(begin);
            }
        }
        return res;
    }

    private static boolean isAnagram(char[] sc, char[] pc) {
        Arrays.sort(sc);
        if(Arrays.equals(sc, pc)){
            return true;
        }
        return false;

    }

}





























































