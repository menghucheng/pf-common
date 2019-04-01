package com.linkList.bean; /**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:58 PM 2019/3/24
 */

/**
 * 链表结点
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:58 PM 2019/3/24
 *
 */
public class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
