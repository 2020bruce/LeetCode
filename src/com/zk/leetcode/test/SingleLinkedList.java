package com.zk.leetcode.test;

public class SingleLinkedList {
    Node head;

    public SingleLinkedList(){
        head = new Node();
        head.next = null;
    }

    public void insert(int value){
        Node node = new Node(value, null);
        node.next = head.next;
        head.next = node;
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insert(9);
        list.insert(5);
        list.insert(4);
        list.insert(4);
        list.insert(3);
        list.insert(3);
        list.insert(3);
        list.insert(2);
        list.insert(2);
        list.insert(1);
        list.insert(1);
        Node L = list.head;
        Node node = delete(L);
        while(node.next != null){
            node = node.next;
            System.out.println(node.value);
        }

    }
    public static Node delete(Node L){
        if(L.next == null || L.next.next == null){
            return L;
        }
        Node p = L.next, q = L.next.next;
        while(q != null){
            if(p.value != q.value){
                p = p.next;
                q = q.next;
                continue;
            }
            while(q != null && p.value == q.value) {
                q = q.next;
            }
            p.next = q;
        }
        return L;
    }
}
