package com.interview.linkedlist;

import java.util.*;

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		// checking size since PriorityQueue cannot have initial size of 0.
		if (lists == null || lists.length == 0) {
			return null;	
		}

		Queue<ListNode> minHeap = new PriorityQueue<ListNode>(lists.length,
				(node1, node2) -> Integer.compare(node1.val, node2.val));

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		for (ListNode node : lists) {
			if (node != null) {
				minHeap.add(node);
			}
		}

		while (!minHeap.isEmpty()) {
			ListNode node = minHeap.remove();
			tail.next = node;
			tail = tail.next;
			if (node.next != null) {
				minHeap.add(node.next);
			}
		}

		return dummy.next;
	}
}