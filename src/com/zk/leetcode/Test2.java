package com.zk.leetcode;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] spl = line.split(" ");
        int n = spl.length;
        System.out.print(spl[0]);
        String pre = spl[0];
        for (int i = 1; i < n; ++i) {
            if (!pre.equalsIgnoreCase(spl[i])) {
                System.out.print(" " + spl[i]);
                pre = spl[i];
            }
        }
    }

}
