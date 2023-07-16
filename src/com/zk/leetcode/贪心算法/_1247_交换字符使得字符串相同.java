package com.zk.leetcode.贪心算法;

public class _1247_交换字符使得字符串相同 {
    public static void main(String[] args) {
        String s1 = "xy", s2 = "yx";
        int i = minimumSwap(s1, s2);
        System.out.println(i);
    }
    /*
        1.当 s1s1 = "xxxx"，s2s2 = "yyyy" 时，只需交换一次，就可以使两个字符串相等
        2.当 s1s1 = "xyxy"，s2s2 = "yxyx" 时，需要交换两次才可以使两个字符串相等
     */
    public static int minimumSwap(String s1, String s2) {
        int xy = 0, yx = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for(int i = 0; i < c1.length; i++){
            if(c1[i] == c2[i]) continue;
            if(c1[i] == 'x') xy++;
            else yx++;
        }

        if(((xy + yx) & 1) != 0) return -1;
        return xy / 2 + yx / 2 + (xy % 2 * 2);
    }
}
