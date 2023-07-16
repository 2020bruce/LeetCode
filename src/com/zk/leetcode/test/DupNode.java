package com.zk.leetcode.test;

public class DupNode {
    Object object;
    DupNode prior;//前驱指针域
    DupNode next;//后继指针域

    public DupNode(){
        this(null);
    }
    public DupNode(Object object){
        this(object,null,null);
    }
    public DupNode(Object object,DupNode prior,DupNode next){
        this.object = object;
        this.prior = prior;
        this.next = next;
    }
}
