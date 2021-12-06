package com.interview.linkedlist.easy;

import com.interview.linkedlist.others.ListNode;

public class LinkedListCycle {

    /**
     * Use two pointers, walker and runner.
     * <p>
     * walker moves step by step. runner moves two steps at time.
     * <p>
     * if the Linked List has a cycle walker and runner will meet at some
     * point.
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) return true;
        }
        return false;
    }
}
