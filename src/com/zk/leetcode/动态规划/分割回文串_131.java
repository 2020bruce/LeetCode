package com.zk.leetcode.动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 分割回文串_131 {
    public static void main(String[] args) {
        String s = "cdd";
        List<List<String>> partition = partition(s);
        for(List<String> list : partition){
            for(String str : list){
                System.out.print(str + " ");
            }
            System.out.println();

        }
    }
    public static List<List<String>> partition(String s) {
        int n = s.length();
        HashMap<Integer, List<List<String>>> map = new HashMap<>();

        List<List<String>> list = new ArrayList<>();
        List<String> lis = new ArrayList<>();
        lis.add(String.valueOf(s.charAt(0)));
        list.add(lis);
        map.put(0, list);


        for(int i = 1; i < n; i++){
            list = new ArrayList<>();
            List<String> t;
            for(int j = 0; j < map.get(i - 1).size(); j++){
                t = new ArrayList<>();
                for(String ls : map.get(i - 1).get(j)){
                    t.add(ls);
                }
                t.add(String.valueOf(s.charAt(i)));
                list.add(t);

            }

            for(int j = i - 1; j >= 0; j--){
                if(isPalindrome(s, j, i)){
                    List<String> l3 = new ArrayList<>();


                    if(j  == 0){
                        l3.add(s.substring(j, i+1));
                        list.add(l3);
                    }else{
                        for(int k = 0; k < map.get(j - 1).size(); k++){
                            t = new ArrayList<>();
                            for(String ls : map.get(j - 1).get(k)){
                                t.add(ls);
                            }
                            t.add(s.substring(j, i+1));
                            list.add(t);
                        }
                    }

                }
            }
            map.put(i, list);
        }
        return map.get(n - 1);
    }
    private static boolean isPalindrome(String s, int begin, int end){
        while(begin < end){
            if(s.charAt(begin) != s.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
