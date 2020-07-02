package com.interview.linkedlist;

public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		ListNode index = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				while (slow != index) {
					slow = slow.next;
					index = index.next;
				}
				return index;
			}
		}
		return null;
	}

}
