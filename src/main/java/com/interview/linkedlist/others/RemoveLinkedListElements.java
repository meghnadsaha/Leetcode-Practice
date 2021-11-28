package com.interview.linkedlist.others;

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode curr = head, prev = fakeHead;
		while (curr != null) {
			if (curr.val == val) {
				prev.next = curr.next;
			} else {
				prev = prev.next;
			}
			curr = curr.next;
		}
		return fakeHead.next;
	}
}