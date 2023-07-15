package com.zk.leetcode.双指针;

public class _61_旋转链表 {
    public static void main(String[] args) {
        int[] head = {0,1,2};
        int k = 4;
        ListNode node = ListUtils.createList(head);
        ListNode listNode = rotateRight(node, k);
        ListUtils.show(listNode);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        int nodeCount = 1;
        while(temp.next != null){
            temp = temp.next;
            nodeCount++;
        }
        temp.next = head;
        int step = nodeCount - k % nodeCount;
        ListNode t = head;
        for(int i = 0; i < step; i++){
            temp = temp.next;
            t = t.next;
        }
        head = t;
        temp.next = null;
        return head;
    }
}

































