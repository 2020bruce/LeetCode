package com.zk.leetcode.哈希表;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);

        Student student = new Student();
        student.names[0] = "hello";
        student.stream().map(s->"1" + s).forEach(System.out::println);

    }
}

class Student implements Collection {
    String[] names = new String[10];

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
//        return new Iterator() {
//            int n = 10;
//            int cur;
//            int lastRet = -1;
//            @Override
//            public boolean hasNext() {
//                return n != cur;
//            }
//
//            @Override
//            public Object next() {
//                int i = cur;
//                cur = i + 1;
//                return names[lastRet = i];
//            }
//        };
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}



