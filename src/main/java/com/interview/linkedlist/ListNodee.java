package com.interview.linkedlist;

public class ListNodee {

	int val;
	ListNodee next;

	ListNodee() {
	}

	ListNodee(int val) {
		this.val = val;
		next = null;
	}

	ListNodee(int val, ListNodee next) {
		this.val = val;
		this.next = next;
	}
}