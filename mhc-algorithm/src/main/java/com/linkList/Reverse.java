/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：11:58 PM 2019/3/24
 */
package com.linkList;

import com.linkList.bean.ListNode;

/**
 * 单向列表翻转
 * @desc       ：
 * @author     ：tigermeng.
 * @date       ：11:58 PM 2019/3/24
 *
 */
public class Reverse {

    public static void main(String[] args) {

    }

    public static void reverse(ListNode listNode){
        if(listNode == null){
            return;
        }
        ListNode tempNode = listNode;
        while(tempNode != null){
            //1、将当前结点的下一个结点取出
            ListNode node = tempNode.getNext();

            //下一个结点的下一个结点放在当前结点位置
            tempNode.setNext(node.getNext());

            //将当前结点放在




        }

    }
}
