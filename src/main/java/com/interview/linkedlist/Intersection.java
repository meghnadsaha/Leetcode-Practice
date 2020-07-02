package com.interview.linkedlist;

public class Intersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode A = headA;
		ListNode B = headB;
		while (A != null && B != null) {
			A = A.next;
			 B = B.next; 
		}
		int bdiff = 0;
		int adiff = 0;
		if (A == null && B == null) {
			A = headA;
			B = headB;
		} else if (A == null) {
			while (B != null) {
				B = B.next;
				bdiff++;
			}
		} else {
			while (A != null) {
				A = A.next;
				adiff++;
			}
		}
		while (adiff > 0) {
			headA = headA.next;
			adiff--;
		}
		while (bdiff > 0) {
			headB = headB.next;
			bdiff--;
		}
		while (headA != null && headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}
}