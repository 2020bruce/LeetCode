package com.zk.twoPointers;

import java.util.List;

public class _143_ReorderList {
    public static void main(String[] args) {
        ListNode head = ListUtils.createList(new int[]{1,2,3,4,5});
        reorderList(head);
        ListUtils.show(head);
    }
    public static void reorderList(ListNode head) {
        int length = ListUtils.length(head);
        ListNode p = head, q = head;
        int move = (length - 1) / 2;
        for(int i = 0; i < move; i++){
            q = q.next;
        }
        ListNode r = q.next;
        q.next = null;
        while(r != null){
            ListNode t = r.next;
            r.next = q.next;
            q.next = r;
            r = t;
        }
        r = p.next;
        ListNode t = q.next;
        q.next = null;
        q = t;
        t = q.next;
        System.out.println(p.val + " " + q.val + " " + r.next + " " + t.val);
        while(p != null && q != null){
            p.next = q;
            q.next = r;
            p = r;
            if(r != null){
                r = r.next;
            }
            q = t;
            if(t != null){
                t = t.next;
            }
        }


    }
}
