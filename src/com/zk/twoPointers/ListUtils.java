package com.zk.twoPointers;

public class ListUtils {
    private ListUtils(){}

    public static ListNode createList(int[] arr){
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int val : arr) {
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return head.next;
    }

    public static void show(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static int length(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        return length;
    }
}
