package com.zk.leetcode.动态规划;

import java.util.*;

public class BD202203_简单题 {

    /**
     * boolean[] dp dp[i]表示前i个数字是否符合条件；
     * int[] asc asc[i]表示第i个元素最为结尾元素的最长上升子序列的元素个数
     * int[] desc desc[i]表示第i个元素最为结尾元素的最长下降子序列的元素个数
     * 1.
     * 2.
     * 3.
     * @param args
     */
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        // code here
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        input.close();

//        Random random = new Random();
//        int n = random.nextInt(50);
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//            arr[i] = random.nextInt(50);
//        }

//        int[] arr = {1, 1, 4, 5, 1, 4};
//        int n = arr.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] asc = new int[n];
        asc[0] = 1;

        int ascMaxNum = 0;

        for(int i = 1; i < n; i++){
            asc[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] >= arr[j]){
                    if(asc[i] < asc[j] + 1){
                        asc[i] = asc[j] + 1;
                        List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                        list.clear();
                        list.add(j);
                        map.put(i, list);
                    }else if(asc[i] == asc[j] + 1){
                        asc[i] = asc[j] + 1;
                        List<Integer> list = map.getOrDefault(i, new ArrayList<>());
                        list.add(j);
                        map.put(i, list);
                    }
                    ascMaxNum = Math.max(ascMaxNum, asc[i]);
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();


        for(int i = 0; i < n; i++){
            if(asc[i] == ascMaxNum){
                stack.add(i);
                while(!stack.isEmpty()){
                    int pop = stack.pop();
                    temp.add(pop);
                    if(map.containsKey(pop)){
                        stack.addAll(map.get(pop));
                    }else{
                        list.add(new ArrayList<>(temp));
                        temp.clear();
                    }
                }
            }
        }

        for(List<Integer> l : list){
            for(int i = 0; i < l.size(); i++){
                if(!l.contains(i)){

                }
            }
        }


        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            System.out.println(entry.getKey());
            entry.getValue().forEach(o-> System.out.print(o + " "));
            System.out.println("\n");
        }

//        System.out.println(Arrays.toString(asc));
//        System.out.println(Arrays.toString(desc));


    }
}
