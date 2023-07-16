package com.zk.leetcode.记忆化搜索;

import java.util.HashMap;

public class _464_我能赢吗 {
    public static void main(String[] args) {
        int maxChoosableInteger = 3, desiredTotal = 6;
        boolean b = canIWin(maxChoosableInteger, desiredTotal);
        System.out.println(b);
    }
    static HashMap<Integer, Boolean> hashMap = new HashMap<>();
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //特殊情况，所有元素的和都小于预期值，则永远无法赢
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        dfs(maxChoosableInteger, 0, desiredTotal, 0);
        System.out.println(hashMap.get(1));
        return hashMap.get(0);
    }

    private static void dfs(int maxChoosableInteger, int usedNumbers, int desiredTotal, int curTotal) {
        if (hashMap.get(usedNumbers) != null) {
            return;
        }
        boolean res = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if (((usedNumbers >> i) & 1) == 0) {
                if (i + 1 + curTotal >= desiredTotal) {
                    res = true;
                    break;
                }
                dfs(maxChoosableInteger, usedNumbers | (1 << i), desiredTotal, curTotal + i + 1);
                if (!hashMap.get(usedNumbers | (1 << i))) {
                    res = true;
                    break;
                }
            }
        }
        hashMap.put(usedNumbers, res);
    }
}











