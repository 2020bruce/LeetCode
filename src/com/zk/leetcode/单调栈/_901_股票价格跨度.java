package com.zk.leetcode.单调栈;

import java.util.Stack;

public class _901_股票价格跨度 {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }

}
/*
输入：
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
输出：
[null, 1, 1, 1, 2, 1, 4, 6]
 */
class StockSpanner{
    Stack<Integer[]> stack;
    int idx;
    public StockSpanner() {
        stack = new Stack<>();
        stack.push(new Integer[]{-1, Integer.MAX_VALUE});
        idx = -1;
    }
    public int next(int price) {
        idx++;
        while(stack.peek()[1] <= price){
            stack.pop();
        }
        int res = idx - stack.peek()[0];
        stack.push(new Integer[]{idx, price});
        return res;
    }
}
/*
class StockSpanner{
    Stack<Integer> valueStack;
    Stack<Integer> ansStack;
    public StockSpanner() {
        valueStack = new Stack<>();
        ansStack = new Stack<>();
    }

    public int next(int price) {
        int t = 1;
        while (!valueStack.isEmpty() && price >= valueStack.peek()) {
            valueStack.pop();
            t += ansStack.pop();
        }
        valueStack.push(price);
        ansStack.push(t);
        return ansStack.peek();
    }
}
*/



