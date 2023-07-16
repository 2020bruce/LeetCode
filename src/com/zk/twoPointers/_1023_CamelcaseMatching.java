package com.zk.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class _1023_CamelcaseMatching {
    public static void main(String[] args) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        List<Boolean> booleanList = camelMatch(queries, pattern);
        booleanList.forEach(o-> System.out.print(o + " "));
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> list = new ArrayList<>();
        for(String query : queries){
            int i = 0, j = 0;
            for(; i < query.length(); i++){
                if(j < pattern.length() && query.charAt(i) == pattern.charAt(j)){
                    j++;
                }else if(query.charAt(i) < 97){
                    list.add(false);
                    break;
                }
            }
            if(i == query.length()){
                if(j == pattern.length()){
                    list.add(true);
                }else{
                    list.add(false);
                }
            }

        }
        return list;
    }
}
