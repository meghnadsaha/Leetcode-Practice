package com.interview.design;

public class MinStack {

	private node top = null;

	private static class node {
		private int data;
		private int min;
		private node next;

		public node(int data, int min) {
			this.data = data;
			this.min = min;
		}
	}

	public MinStack() {
	}

	public void push(int x) {
		node t;
		if (top != null) {
			t = new node(x, Math.min(x, top.min));
			t.next = top;
		} else {
			t = new node(x, x);
		}
		top = t;
	}

	public void pop() {
		top = top.next;
	}

	public int top() {
		return top.data;
	}

	public int getMin() {
		return top.min;
	}
}