package com.zk.leetcode.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class TestStream {
    public static void main(String[] args) {
        int[] arr = {10, 20, 1, 2, 30, 22};
        IntStream stream = Arrays.stream(arr);
        int sum = stream.sum();
        System.out.println(sum);
        List<String> al = Arrays.asList("a","b","c","d");
        Optional<String> max = al.stream().max((a, b) -> a.charAt(0) - b.charAt(0));
        System.out.println(max.get());

    }
}
