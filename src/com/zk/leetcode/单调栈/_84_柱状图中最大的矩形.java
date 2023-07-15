package com.zk.leetcode.单调栈;

import java.util.Stack;

public class _84_柱状图中最大的矩形 {
    public static void main(String[] args) {
        int[] heights = {0,2,0};
        int area = largestRectangleArea(heights);
        System.out.println(area);
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = heights[0];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int pop = stack.pop();
                int width;
                while(!stack.isEmpty()&& heights[pop] == heights[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peek() - 1;
                }
                System.out.println(heights[pop] + " " + width);
                maxArea = Math.max(maxArea, heights[pop] * width);

            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int pop = stack.pop();
            while(!stack.isEmpty()&& heights[pop] == heights[stack.peek()]){
                stack.pop();
            }
            int width;
            if(stack.isEmpty()){
                width = n;
            }else{
                width = n - stack.peek() - 1;
            }
            maxArea = Math.max(maxArea, heights[pop] * width);
        }

        return maxArea;
    }

    public static int largestRectangleAreaBetter(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < tmp.length; i++){
            while(!stack.isEmpty() && tmp[i] < tmp[stack.peek()]){
                int pop = stack.pop();
                maxArea = Math.max(maxArea, tmp[pop] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        return maxArea;
    }
}
