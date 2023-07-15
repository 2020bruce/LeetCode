package com.zk.leetcode.动态规划;

public class _474_一和零 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int i = findMaxForm(strs, 5, 3);
        System.out.println(i);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m + 1][n + 1];//f[i][j]表示存储容量为i， j时能装入字符串的最大数量

        int zero, one;
        //逐渐加入字符串
        for(String str : strs){
            zero = 0;//字符串中‘0’的数量
            one = 0;//字符串中‘1’的数量
            for(char c : str.toCharArray()){
                if(c == '0'){
                    zero++;
                }else{
                    one++;
                }
            }

            for(int i = m; i >= zero; i--){
                for(int j = n; j >= one; j--){
                    //最大字符串数量=不加此字符串时最大数量和加了此字符串的最大数量的最大值
                    f[i][j] = Math.max(f[i][j], f[i - zero][j - one] + 1);
                }
            }

        }
        return f[m][n];

    }
}
