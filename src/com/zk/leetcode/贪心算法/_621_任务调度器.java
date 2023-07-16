package com.zk.leetcode.贪心算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _621_任务调度器 {
    public static void main(String[] args) {
        char[] tasks = {'A'};
        int n = 1;
        int i = leastInterval(tasks, n);
        System.out.println(i);
    }
    //不超时，但效率也较低
    public int leastIntervalSecond(char[] tasks, int n) {
        //计数Map
        Map<Character,Integer> countMap = new HashMap<>();
        //冷却时间Map
        Map<Character,Integer> timeMap = new HashMap<>();
        //初始化两个Map
        for(char c:tasks){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
            timeMap.put(c,0);
        }
        //记录调度轮数
        int resCount = 0;
        //记录已调度字母的个数
        int count = 0;
        while(count < tasks.length){
            //寻找数组种第一个冷却时间为0，且计数大于零的字母
            char tmp = 'a';
            for(char c:timeMap.keySet()){
                if(timeMap.get(c)==0 && countMap.get(c)>0){
                    tmp=c;
                    break;
                }
            }
            //若不存在则进入一轮待命状态
            if(tmp=='a'){
                resCount++;
                for(char c:timeMap.keySet()){
                    if(timeMap.get(c)>0) timeMap.put(c,timeMap.get(c)-1);
                }
                continue;
            }
            //寻找冷却时间为0中计数最大的字母
            for(char c:countMap.keySet()){
                if(timeMap.get(c)==0 && countMap.get(tmp)<countMap.get(c)) tmp = c;
            }
            countMap.put(tmp,countMap.get(tmp)-1);
            for(char c:timeMap.keySet()){
                if(timeMap.get(c)>0) timeMap.put(c,timeMap.get(c)-1);
            }
            timeMap.put(tmp,n);
            count++;
            resCount++;
        }
        return resCount;
    }

    //超时
    public static int leastInterval(char[] tasks, int n) {
        if(n == 0 || tasks.length == 1){
            return tasks.length;
        }
        Arrays.sort(tasks);
        int[] count = new int[26];
        HashMap<Integer, ArrayList<Character>> hashtable = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            count[tasks[i] - 'A']++;
            hashtable.put(i, new ArrayList<>());
        }
        int max = -1;
        int time = 0;
        int ind = 0;
        while(max != 0){
            max = 0;

            for(int i = 0; i <= 25; i++){
                if(max < count[i]){
                    max = count[i];
                    ind = i;
                }
            }
            if(max == 0){
                break;
            }
            count[ind]--;
            for(int j = 0; j < tasks.length; j++){
                if((hashtable.get(j).size() == n + 1) || hashtable.get(j).contains((char)(ind + 'A'))){
                    continue;
                }
                ArrayList<Character> list = hashtable.get(j);
                list.add((char) (ind + 'A'));
                break;
            }

        }


        int index = tasks.length - 1;
        for(int i = 0; i < tasks.length; i++) {
            ArrayList<Character> list = hashtable.get(i);
            if (!list.isEmpty()) {
                time += n + 1;
            } else {
                index = i;
                break;
            }
        }

        return time - (n + 1 - hashtable.get(index - 1).size());
    }

}











