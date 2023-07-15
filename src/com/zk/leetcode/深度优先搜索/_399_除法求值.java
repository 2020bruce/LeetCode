package com.zk.leetcode.深度优先搜索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class _399_除法求值 {
    public static void main(String[] args) {
        String[][] equations = {{"a","b"},{"b","c"},{"bc","cd"}};
        List<List<String>> listsEquations = new ArrayList<>();
        for(String[] equation : equations){
            List<String> list = Arrays.stream(equation).collect(Collectors.toList());
            listsEquations.add(list);
        }
        double[] values = {1.5,2.5,5.0};
        String[][] queries = {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}};
        List<List<String>> listsQueries = new ArrayList<>();
        for(String[] query : queries){
            List<String> list = Arrays.stream(query).collect(Collectors.toList());
            listsQueries.add(list);
        }
        double[] doubles = calcEquation(listsEquations, values, listsQueries);
        System.out.println(Arrays.toString(doubles));

    }
    static HashMap<String, List<Edge>> map = new HashMap();
    static HashMap<String, Boolean> isVisited = new HashMap<>();
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int index = 0;
        for(List<String> equation : equations){
            String from = equation.get(0);
            String to = equation.get(1);
            double val = values[index++];
            if(!map.containsKey(from)){
                map.put(from, new ArrayList<>(){{
                    add(new Edge(to, val));
                    add(new Edge(from, 1.0d));
                }});
                isVisited.put(from, false);
            }else{
                List<Edge> edges = map.get(from);
                edges.add(new Edge(to, val));
            }
            if(!map.containsKey(to)){
                map.put(to, new ArrayList<>(){{
                    add(new Edge(from, 1 / val));
                    add(new Edge(to, 1.0d));
                }});
                isVisited.put(to, false);
            }else{
                List<Edge> edges = map.get(to);
                edges.add(new Edge(from, 1 / val));
            }
        }
        double[] res = new double[queries.size()];
        index = 0;
        for(List<String> query : queries){
            for(String key : isVisited.keySet()){
                isVisited.put(key, false);
            }
            res[index++] = dfs(query, query.get(0));
        }

        return res;
    }

    private static double dfs(List<String> query, String from) {
        String begin = query.get(0);
        String end = query.get(1);
        if(!map.containsKey(begin) || !map.containsKey(end)){
            return -1.0d;
        }
        if (from.equals(end)) {
            return 1.0d;
        }
        isVisited.put(from, true);
        for(Edge edge : map.get(from)){
            if(isVisited.get(edge.to)){
                continue;
            }
            double ans = dfs(query, edge.to);
            if(ans != -1.0){
                return ans * edge.val;
            }
        }

        return -1.0d;
    }
}


class Edge{
    String to;
    double val;
    public Edge(String to, double val) {
        this.to = to;
        this.val = val;
    }
}

















