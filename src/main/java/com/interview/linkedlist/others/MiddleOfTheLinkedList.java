package com.interview.linkedlist.others;

public class MiddleOfTheLinkedList {

	/**
	 * 
	 * Each time, slow go 1 steps while fast go 2 steps. When fast arrives at
	 * the end, slow will arrive right in the middle.
	 */	
	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
