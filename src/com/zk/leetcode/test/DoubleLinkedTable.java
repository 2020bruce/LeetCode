package com.zk.leetcode.test;

public class DoubleLinkedTable {
    //头结点
    DupNode head;

    public DoubleLinkedTable(){
        head = new DupNode();
        head.prior = head;
        head.next = head;
    }
    //长度
    public int length(){
        DupNode node = head.next;
        int j = 0;
        while(!node.equals(head)){
            j++;
            node = node.next;
        }
        return j;
    }

    //打印
    public void display(){
        DupNode node = head.next;
        while(!node.equals(head)){
            System.out.println(node.object);
            node = node.next;
        }
    }
    //清空
    public void clear(){
        head.next = head;
        head.prior = head;
    }

    //插入
    public void insert(int i,Object object) throws Exception {
        if (i < 0 || i > length())
            throw new Exception("下标不合法");
        DupNode node = head;
        int j = 0;
        while (!node.next.equals(head) && j < i) {
            j++;
            node = node.next;
        }
        DupNode newNode = new DupNode(object, node, node.next);
        node.next.prior = newNode;
        node.next = newNode;
    }

    //删除
    public void remove(int i) throws Exception{
        if(i<0 || i>length()-1)
            throw new Exception("下标不合法");
        DupNode node = head;
        int j = 0;
        while(!node.next.equals(head) && j<i){
            j++;
            node = node.next;
        }
        node.next = node.next.next;
        node.next.prior = node;
    }

    //根据下标获取
    public Object get(int i) throws Exception{
        return getNode(i).object;
    }

    //根据下标获取其前一个元素
    public Object getPrior(int i) throws Exception{
        return getNode(i).prior.object;
    }

    //根据下标获取其后一个元素
    public Object getNext(int i) throws Exception{
        return getNode(i).next.object;
    }

    public DupNode getNode(int i) throws Exception{
        if(i<0 || i>length())
            throw new Exception("下标不合法");
        DupNode node = head.next;
        int j =0;
        while(!node.equals(head) && j<i){
            j++;
            node = node.next;
        }
        return node;
    }

    public DupNode getHead(){
        return this.head;
    }

}
