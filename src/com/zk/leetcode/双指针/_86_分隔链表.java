package com.zk.leetcode.双指针;

public class _86_分隔链表 {
    public static void main(String[] args) {
        int[] head = {2,1};
        int x = 2;
        ListNode list = ListUtils.createList(head);
        ListNode partition = partition(list, x);
        ListUtils.show(partition);
    }
    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode low = new ListNode();
        ListNode l = low;
        ListNode high = new ListNode();
        ListNode h = high;
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                l.next = temp;
                l = temp;
            }else{
                h.next = temp;
                h = temp;
            }
            temp = temp.next;
        }
        l.next = high.next;
        h.next = null;
        ListNode res = low.next;

        return res;
    }
}


































