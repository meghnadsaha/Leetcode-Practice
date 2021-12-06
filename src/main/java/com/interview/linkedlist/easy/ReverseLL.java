package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;

public class ReverseLL {

    public ListNode reverseList(ListNode head) {//1,2,3,4,5
        ListNode prev = null;//null
        while (head != null) {
            ListNode n = head.next;//2,3,4,5 //3,4,5  //4,5 //5//null
            head.next = prev;//1->null //2->1->null //3->2->1->null//4->3->2->1->null//5->4->3->2->1->null
            prev = head;//1->null //2->1->null//3->2->1->null//4->3->2->1->null//5->4->3->2->1->null
            head = n;//2,3,4,5 //3,4,5 //4,5//5//null
        }
        return prev;
    }
}