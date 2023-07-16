package com.zk.leetcode.贪心算法;

import java.util.HashMap;

public class 森林中的兔子_781 {
    public static void main(String[] args) {
        int[] answers = {0,0,1,1,1};
        int i = numRabbits(answers);
        System.out.println(i);
    }
    //x/y向上取整公式(x - 1)/y + 1
    public static int numRabbits(int[] answers) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int ans : answers){
            hashMap.put(ans, hashMap.getOrDefault(ans, 0) + 1);
        }
        int res = 0;
        for(int key : hashMap.keySet()){
            if(hashMap.get(key) > key + 1){
                res += (key + 1) * (hashMap.get(key) % (key + 1) == 0 ? hashMap.get(key) / (key + 1) : hashMap.get(key) / (key + 1) + 1);
            }else{
                res += key + 1;
            }
        }
        return res;
    }
}










