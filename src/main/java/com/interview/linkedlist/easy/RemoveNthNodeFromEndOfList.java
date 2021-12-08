package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/1164542/JS-Python-Java-C%2B%2B-or-Easy-Two-Pointer-Solution-w-Explanation

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next; // Current Fast = 3,4,5
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;//4,5 -> //5 -> //null
            slow = slow.next;// 2, 3, 4, 5 -> // 3, 4, 5
        }
        //Old slow  = 3    4      5
        //            s  next   next
        //New Slow =  3    5
        slow.next = slow.next.next;
        return head;
    }
}
