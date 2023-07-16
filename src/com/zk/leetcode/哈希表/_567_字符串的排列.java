package com.zk.leetcode.哈希表;

public class _567_字符串的排列 {
    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";
        boolean b = checkInclusionBest(s1, s2);
        System.out.println(b);

    }
    public static boolean checkInclusionBest(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m){
            return false;
        }
        int[] s1CharNum = new int[26];
        for(int i = 0; i < n; i++){
            s1CharNum[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for(int right = 0; right < m; right++){
            int t = s2.charAt(right) - 'a';
            s1CharNum[t]++;
            while(s1CharNum[t] > 0){
                --s1CharNum[s2.charAt(left) - 'a'];
                ++left;
            }
            if(right - left + 1 == n){
                return true;
            }

        }
        return false;
    }
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m){
            return false;
        }
        int[] s1CharNum = new int[26];
        for(int i = 0; i < n; i++){
            s1CharNum[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        int count = 0;
        for(int right = left; right < m; right++){
            int t = s2.charAt(right) - 'a';
            if(s1CharNum[t] > 0){
                s1CharNum[t]--;
                count++;
                if(count == n){
                    return true;
                }
            }else{
                count = 0;
                int r = right - 1;
                while(r >= left){
                    s1CharNum[s2.charAt(r) - 'a']++;
                    r--;
                }
                left++;
                right = left - 1;
            }

        }
        return false;
    }
}
