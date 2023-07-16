package com.zk.twoPointers;

public class _19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] head = {1,2};
        int n = 2;
        ListNode node = ListUtils.createList(head);
        ListNode listNode = removeNthFromEnd(node, n);
        ListUtils.show(listNode);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head, right = head;
        for(int i = 0; i < n; i++){
            right = right.next;
        }
        if(right == null){
            return head.next;
        }
        while(right.next != null){
            left = left.next;
            right = right.next;
        }
        if(left.next != null){
            left.next = left.next.next;
        }
        return head;
    }
}
