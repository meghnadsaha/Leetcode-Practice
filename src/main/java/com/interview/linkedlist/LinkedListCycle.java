package com.interview.linkedlist;

public class LinkedListCycle {

	/**
	 * Use two pointers, walker and runner. walker moves step by step. 
	 * Runner moves two steps at time. 
	 * If the Linked List has a cycle walker and runner
	 * will meet at some point.
	 */	
	public boolean hasCycle(ListNode head) {
		ListNode walker = head;
		ListNode runner = head;
		while (runner != null && runner.next != null) {
			walker = walker.next;
			runner = runner.next.next;
			if (walker == runner)
				return true;
		}
		return false;
	}
}
