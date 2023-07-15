package com.zk.leetcode.哈希表;


import java.util.HashSet;
import java.util.Set;

public class _817_链表组件 {
    public static void main(String[] args) {
        int[] headArr = {0,1,2,3}, nums = {0,1,3};
        ListNode head = new ListNode(headArr[0]);
        ListNode temp = head;
        for(int i = 1; i < headArr.length; i++){
            temp.next = new ListNode(headArr[i]);
            temp = temp.next;
        }
        int i = numComponents(head, nums);
        System.out.println(i);
    }
    public static int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            if(!set.contains(temp.val)){
                count++;
            }
            while(temp != null && !set.contains(temp.val)){
                temp = temp.next;
            }
            if(temp != null){
                temp = temp.next;
            }else{
                count--;
            }
        }
        if(!set.contains(head.val)){
            count--;
        }
        return count + 1;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

