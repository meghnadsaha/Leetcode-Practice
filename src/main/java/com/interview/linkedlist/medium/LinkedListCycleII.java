package com.interview.linkedlist.medium;

import com.interview.linkedlist.others.ListNode;

//https://leetcode.com/problems/linked-list-cycle-ii/discuss/44781/Concise-O(n)-solution-by-using-C%2B%2B-with-Detailed-Alogrithm-Description

public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode entry = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {                      // there is a cycle
                while (slow != entry) {               // found the entry location
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;                                 // there has no cycle
    }
}
