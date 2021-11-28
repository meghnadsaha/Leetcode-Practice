package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }

        return false;
    }
}
