package com.zk.leetcode.双指针;

public class _82_删除排序链表中的重复元素II {

    public static void main(String[] args) {
        int[] headArr = {1,2,3};
        ListNode head = new ListNode(headArr[0]);
        ListNode temp = head;
        int n = headArr.length;
        for(int i = 1; i < n; i++){
            temp.next = new ListNode(headArr[i]);
            temp = temp.next;
        }
        ListNode listNode = deleteDuplicates(head);
        ListNode t = listNode;
        while(t != null){
            System.out.print(t.val + " ");
            t = t.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode resHead = new ListNode(0, head);
        ListNode left = resHead;
        ListNode right = resHead.next;
        while(right != null && right.next != null){
            while(right.next != null && right.val != right.next.val){
                right = right.next;
                left = left.next;
            }
            while(right.next != null && right.val == right.next.val){
                right = right.next;
            }
            if(left.next != right){
                right = right.next;
                left.next = right;
            }
        }
        return resHead.next;
    }


}






















































