package com.zk.leetcode.双指针;

public class _522_最长特殊序列II {
    public static void main(String[] args) {
        String[] strs = {"aaaaa","aaaaaa","aaa","aaa"};
        int length = findLUSlength(strs);
        System.out.println(length);
    }

    /**
     * 1.两层for循环两两进行对比，都从0开始，如果i！=j则进行对比
     * 2.如果strs[i]是strs[j]的子序列则break
     * 3.如果j == n则记录strs[i]的长度
     *
     * @param strs
     * @return
     */
    public static int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for(int i = 0; i < n; i++){
            boolean broke = false;
            for(int j = 0; j < n; j++){
                if(i != j){
                    if(isSub(strs[i], strs[j])){
                        broke = true;
                        break;
                    }
                }
            }
            if(!broke){
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    private static boolean isSub(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if(n1 > n2){
            return false;
        }else if(n1 == n2){
            return s1.equals(s2);
        }else{
            int i = 0, j = 0;
            while(i < n1 && j < n2){
                if(s1.charAt(i) == s2.charAt(j)){
                    i++;
                }
                j++;
            }
            return i == n1;
        }
    }

}

























