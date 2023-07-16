package com.zk.leetcode.哈希表;

public class _767_重构字符串 {
    public static void main(String[] args) {
        String s = "vvvlo";
        String string = reorganizeString(s);
        System.out.println(string);
    }

    public static String reorganizeString(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] letter = new int[26];
        for(int i = 0; i < n; i++){
            letter[c[i] - 'a']++;
        }
        int maxIndex = 0;
        for(int i = 0; i < 26; i++){
            if(letter[maxIndex] < letter[i]){
                maxIndex = i;
            }
        }

        if(letter[maxIndex] > (n + 1) / 2){
            return "";
        }

        char[] res = new char[n];
        int i = 0;
        while(letter[maxIndex]-- > 0){
            res[i] = (char)(maxIndex + 'a');
            i += 2;
        }

        for(int j = 0; j < 26; j++){
            while(letter[j]-- > 0){
                if(i >= n){
                    i = 1;
                }
                res[i] = (char)('a' + j);
                i += 2;
            }
        }



        return String.valueOf(res);
    }
}
