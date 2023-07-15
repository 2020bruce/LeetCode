package com.zk.leetcode.哈希表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _690_员工的重要性 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<>();
        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<>();
        ArrayList<Integer> e1_subordinates = new ArrayList<>();
        e1_subordinates.add(2);
        e1_subordinates.add(3);
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = e1_subordinates;
        Collections.addAll(employees, e1, e2, e3);
        int id = 1;
        int importance = getImportance(employees, id);
        System.out.println(importance);
    }
    static int sum;
    public static int getImportance(List<Employee> employees, int id) {
        int index = getIndexById(employees, id);
        return dfs(employees, index);
    }

    private static int dfs(List<Employee> employees, int index) {
        if(employees.size() == 0){
            return 0;
        }
        Employee employee = employees.get(index);
        sum += employee.importance;
        for(int i : employee.subordinates){
            int tempIndex = getIndexById(employees, i);
            dfs(employees, tempIndex);
        }
        return sum;

    }

    private static int getIndexById(List<Employee> employees, int id) {
        int index = 0;
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).id == id){
                index = i;
            }
        }
        return index;
    }
}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};







































