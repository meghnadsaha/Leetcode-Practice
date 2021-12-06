package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;

public class IntersectionOfTwoLL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while( a != b){

            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }


        return a;
    }
}
