package com.zk;

public class Main {

    public static void main(String[] args) {
        int x = 10000;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(x & -x);
    }

}
