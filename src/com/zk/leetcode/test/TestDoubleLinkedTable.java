package com.zk.leetcode.test;

public class TestDoubleLinkedTable {
    public static void main(String[] args) throws Exception {
        DoubleLinkedTable table = new DoubleLinkedTable();
        table.insert(0, 120);
        table.insert(1, 110);
        table.insert(2, 115);
        DupNode L = table.getHead();
        DupNode p = table.getNode(0);
        DupNode q = table.getNode(1);
        DupNode r = table.getNode(2);
        while(q != L){
            while((p != L) && ((Integer)p.object > (Integer) q.object))
                p = p.prior;
            q.prior.next = r;
            r.prior = q.prior;
            q.next = p.next;
            q.prior = p;
            p.next.prior = q;
            p.next = q;
            q = r;
            p = q.prior;
            r = r.next;
            table.display();
            System.out.println();
        }

    }
}
