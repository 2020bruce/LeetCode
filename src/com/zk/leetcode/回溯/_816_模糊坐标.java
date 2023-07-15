package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class _816_模糊坐标 {
    public static void main(String[] args) {
        String s = "(0123)";
        List<String> list = ambiguousCoordinates(s);
        for(String ls : list){
            System.out.println(ls);
        }
    }
    public static List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        int n = s.length();
        List<String> res = new ArrayList<>();
        for(int i = 1; i < n; i++){
            List<String> ll = new ArrayList<>();
            String ls = s.substring(0, i);
            getPos(ll, ls);
            if(ll.size() <= 0){
                continue;
            }
            List<String> rl = new ArrayList<>();
            String rs = s.substring(i);
            getPos(rl, rs);
            if(rl.size() <= 0){
                continue;
            }
            for(int j = 0; j < ll.size(); j++){
                for(int k = 0; k < rl.size(); k++){
                    res.add("(" + ll.get(j) + ", " + rl.get(k) + ")");
                }
            }

        }

        return res;
    }

    private static void getPos(List<String> l, String s) {
        if(s.charAt(0) != '0' || "0".equals(s)){
            l.add(s);
        }
        for(int i = 1; i < s.length(); i++){
            if((i != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0'){
                continue;
            }
            l.add(s.substring(0, i) + "." + s.substring(i));
        }
    }
}































