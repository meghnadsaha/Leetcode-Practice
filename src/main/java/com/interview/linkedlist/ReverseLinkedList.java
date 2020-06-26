package com.interview.linkedlist;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		if (head.next.next == null) {
			ListNode temp = head.next;
			head.next = null;
			temp.next = head;
			return temp;
		}
		ListNode curr = head;
		ListNode nex = head.next;
		ListNode ahead = head.next.next;
		ListNode tail = new ListNode(0);
		boolean found = false;

		while (nex != null) {
			nex.next = curr;
			curr = nex;
			nex = ahead;
			if (!found && nex.next == null) {
				tail = nex;
				found = true;
			}
			if (ahead == null)
				break;
			ahead = ahead.next;
		}

		head.next = null;
		return tail;
	}
}
