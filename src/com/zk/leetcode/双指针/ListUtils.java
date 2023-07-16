package com.zk.leetcode.双指针;

public class ListUtils {
    private ListUtils(){}
    public static ListNode createList(int[] arr){
        int n = arr.length;
        if(n == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1; i < n; i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void show(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
