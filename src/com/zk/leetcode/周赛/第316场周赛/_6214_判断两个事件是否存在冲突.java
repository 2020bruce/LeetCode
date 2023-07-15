package com.zk.leetcode.周赛.第316场周赛;

public class _6214_判断两个事件是否存在冲突 {
    public static void main(String[] args) {
        String[] event1 = {"10:00","11:00"}, event2 = {"14:00","15:00"};
        boolean b = haveConflict(event1, event2);
        System.out.println(b);

    }
    public static boolean haveConflict(String[] event1, String[] event2) {
        String e10 = event1[0];
        String e11 = event1[1];
        String e20 = event2[0];
        String e21 = event2[1];
        return (e20.compareTo(e10) >= 0 && e20.compareTo(e11) <= 0) || (e21.compareTo(e10) >= 0 && e21.compareTo(e11) <= 0);
    }
}












































