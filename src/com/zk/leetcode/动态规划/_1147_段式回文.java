package com.zk.leetcode.动态规划;

public class _1147_段式回文 {
    public static void main(String[] args) {
        String text = "klzosgznatwxkhgbperdpvqpxtrujpvdxybmkrwwtdkwshjancajxmfehdklgjdrictlnienlbbwcmfeblepnikxkeibftbcdecssnakbmclgzudluhxzretmqslgtwqclmdrzecptxbmqqdlddullxqlvdajhcszergxhiqpdglmkvkjjjppbaxjmihcgaxedqpwlououwlxedqpmihcgaxjpbajjpvkjglmkdhiqpzergxjhcsadllxqlvldduqqdtxbmdrzecpwqclmgtqsltmhxzreudlubmclgznakcsscdebtkeibfnikxblepfecmenlbbwirictlnjddklgehjxmfjancadkwshrwwtkdxybmpvtrujdpvqpxergbpwxkhznatglzosk";
        int decomposition = longestDecomposition(text);
        System.out.println(decomposition);
    }
    static final long BASE = 57L;
    public static int longestDecomposition(String text) {
        return help(text, 0, text.length() - 1);
    }

    private static int help(String text, int l, int r) {
        if(l == r){
            return 1;
        }
        if(l > r){
            return 0;
        }
        long hash1 = 0L, hash2 = 0L;
        long c = 1L;
        while(l < r){
            hash1 = hash1 * BASE + text.charAt(l);
            hash2 = hash2 + c * text.charAt(r);
            c *= BASE;
            l++;
            r--;
            if(hash1 == hash2){
                return help(text, l, r) + 2;
            }
        }
        return 1;
    }
}















