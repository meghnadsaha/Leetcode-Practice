package com.interview.linkedlist;

public class CopyListwithRandomPointer {
	public ListNode copyRandomList(ListNode head) {
		if (head == null) {
			return null;
		}

			// copy linked list to following structure A -> A' -> B -> B' .... -> C
		// -> C'
		ListNode p = head;
		while (p != null) {
			ListNode tmp = p.next;
			p.next = new ListNode(p.val);
			p.next.next = tmp;
			p = tmp;
		}

		// copy random list
		p = head;
		while (p != null) {
			if (p.random == null) {
				p.next.random = null;
			} else {
				p.next.random = p.random.next;
			}
			p = p.next.next;
		}

		// split structure A -> A' -> B -> B' => A -> B | A' -> B'
		ListNode newHead = head.next;
		ListNode q = newHead;
		p = head;

		while (p != null) {
			p.next = p.next.next;
			if (p.next == null) {
				q.next = null;
			} else {
				q.next = p.next.next;
			}
			p = p.next;
			q = q.next;
		}

		return newHead;
	}

}