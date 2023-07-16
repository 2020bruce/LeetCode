package com.zk.leetcode.双指针;

public class _844_比较含退格的字符串 {

    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        boolean compare = backspaceCompare(s, t);
        System.out.println(compare);
    }

    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0;
        int skipT = 0;
        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(s.charAt(i) == '#'){
                    skipS++;
                    i--;
                }else if(skipS > 0){
                    skipS--;
                    i--;
                }else{
                    break;
                }
            }
            while(j >= 0){
                if(t.charAt(j) == '#'){
                    skipT++;
                    j--;
                }else if(skipT > 0){
                    skipT--;
                    j--;
                }else{
                    break;
                }
            }
            if(i >= 0 && j >= 0){
                if(s.charAt(i) != t.charAt(j)){
                    return false;
                }
            }else{
                if(i >= 0 || j >= 0){
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}























































