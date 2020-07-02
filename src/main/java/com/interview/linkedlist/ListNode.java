package com.interview.linkedlist;

/*
 * Definition for singly-linked list.
 * */
public class ListNode {

	int val;
	ListNode next;
	Node random;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
		this.next = null;
		this.random = null;

	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}