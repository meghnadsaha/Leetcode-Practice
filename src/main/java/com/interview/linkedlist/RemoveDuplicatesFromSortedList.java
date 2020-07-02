package com.interview.linkedlist;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode list = head;
		while (list.next != null) {
			if (list.val == list.next.val)
				list.next = list.next.next;
			else	
				list = list.next;
		}

		return head;
	}
}
