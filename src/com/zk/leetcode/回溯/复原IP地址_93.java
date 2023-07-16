package com.zk.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

public class 复原IP地址_93 {
    public static void main(String[] args) {
        String s = "101023";
        List<String> list = restoreIpAddresses(s);
        for(String str : list){
            System.out.println(str);
        }
    }
    static List<String> temp = new ArrayList<>();
    static List<String> list = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        backtrack(s, 0);
        return list;
    }

    private static void backtrack(String s, int begin) {
        if(temp.size() == 4 && begin == s.length()){
            list.add(String.join(".", temp));
            return;
        }
        for(int i = begin; i < s.length(); i++){
            String sub = s.substring(begin, i + 1);
            if(i - begin <= 2 && Integer.parseInt(sub) <= 255 && temp.size() < 4){
                if(sub.length() > 1 && s.charAt(begin) == '0'){
                    return;
                }
                temp.add(sub);
                backtrack(s, i + 1);
                temp.remove(temp.size() - 1);
            }else{
                return;
            }
        }
    }
}
