package com.zk.leetcode.哈希表;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _752_打开转盘锁 {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        int i = openLock(deadends, target);
        System.out.println(i);
    }

    public static int openLock(String[] deadends, String target){
        if(target.equals("0000")){
            return 0;
        }
        String begin = "0000";
        Set<String> isVisited = new HashSet<>();
        Collections.addAll(isVisited, deadends);
        if(isVisited.contains(begin)){
            return -1;
        }
        PriorityQueue<AStar> queue = new PriorityQueue<>((a, b) -> a.f - b.f);
        queue.offer(new AStar(begin, target, 0));
        while(!queue.isEmpty()){
            AStar e = queue.poll();
            char[] temp = e.status.toCharArray();
            for(int j = 0; j < 4; j++){
                char t = (char)(temp[j] + 1);
                if(t > '9'){
                    t = '0';
                }
                char[] copy = temp.clone();
                copy[j] = t;
                String s = String.valueOf(copy);
                if(!isVisited.contains(s)){
                    if(s.equals(target)){
                        return e.g + 1;
                    }else{
                        queue.offer(new AStar(s, target, e.g + 1));
                        isVisited.add(s);
                    }
                }
            }
            for(int j = 0; j < 4; j++){
                char t = (char)(temp[j] - 1);
                if(t < '0'){
                    t = '9';
                }
                char[] copy = temp.clone();
                copy[j] = t;
                String s = String.valueOf(copy);
                if(!isVisited.contains(s)){
                    if(s.equals(target)){
                        return e.g + 1;
                    }else{
                        queue.offer(new AStar(s, target, e.g + 1));
                        isVisited.add(s);
                    }
                }
            }

        }


        return -1;
    }








/*    //广度优先搜索
    public static int openLock(String[] deadends, String target) {
        if(target.equals("0000")){
            return 0;
        }
        char[] begin = {'0', '0', '0', '0'};
        Set<String> isVisited = new HashSet<>();
        Collections.addAll(isVisited, deadends);
        Queue<String> queue = new LinkedList<>();
        if(isVisited.contains(String.valueOf(begin))){
            return -1;
        }
        isVisited.add(String.valueOf(begin));
        queue.offer(String.valueOf(begin));
        int ans = 0;
        while(queue.size() > 0){
            ans++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                char[] temp = queue.poll().toCharArray();
                for(int j = 0; j < 4; j++){
                    char t = (char)(temp[j] + 1);
                    if(t > '9'){
                        t = '0';
                    }
                    char[] copy = temp.clone();
                    copy[j] = t;
                    String s = String.valueOf(copy);
                    if(!isVisited.contains(s)){
                        if(s.equals(target)){
                            return ans;
                        }else{
                            queue.offer(s);
                            isVisited.add(s);
                        }
                    }
                }
                for(int j = 0; j < 4; j++){
                    char t = (char)(temp[j] - 1);
                    if(t < '0'){
                        t = '9';
                    }
                    char[] copy = temp.clone();
                    copy[j] = t;
                    String s = String.valueOf(copy);
                    if(!isVisited.contains(s)){
                        if(s.equals(target)){
                            return ans;
                        }else{
                            queue.offer(s);
                            isVisited.add(s);
                        }
                    }
                }
            }
        }
        return -1;
    }*/
}

class AStar{
    String status;
    int f, g, h;

    public AStar(String status, String target, int g){
        this.status = status;
        this.g = g;
        this.h = getH(status, target);
        this.f = this.g + this.h;
    }

    private int getH(String status, String target) {
        int res = 0;
        for(int i = 0; i < 4; i++){
            int cost = Math.abs(status.charAt(i) - target.charAt(i));
            res += Math.min(cost, 10 - cost);
        }
        return res;
    }
}


























