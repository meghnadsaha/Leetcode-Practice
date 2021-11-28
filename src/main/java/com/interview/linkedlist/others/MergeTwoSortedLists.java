package com.interview.linkedlist.others;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = null;

		// If both list nodes aren't empty.
		if (l1 != null && l2 != null) {
			// Find the node with smaller value.
			ListNode selectedNode = (l1.val < l2.val) ? l1 : l2;
			
			// Find the node with greater value.
			ListNode notSelectedNode = (l1.val < l2.val) ? l2 : l1;

			// Set result node equal to the smaller node.
			result = selectedNode;

			// Find the next node recursively by moving one node ahead in the
			// selected list.
			result.next = mergeTwoLists(selectedNode.next, notSelectedNode);
		}
		// If any of the 2 list nodes is empty, then assign the other remaining
		// list to the end of result list.
		else {
			if (l1 == null) {
				result = l2;
			}
			if (l2 == null) {
				result = l1;
			}
		}

		return result;
	}
}
