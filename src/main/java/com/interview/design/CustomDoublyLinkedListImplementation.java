package com.interview.design;

import java.util.*;

/**
 * Implemented LRU cache using Custom LinkedList of LRUNode and HashMap
 */
class CustomDoublyLinkedListImplementation {

	int size;
	int capacity;
	LRUNode head;
	LRUNode tail;
	Map<Integer, LRUNode> map = new HashMap<Integer, LRUNode>();

	class LRUNode {
		int key;
		int data;
		LRUNode previous;
		LRUNode next;

		public LRUNode(int key, int data) {
			this.key = key;
			this.data = data;
		}
	}

	public CustomDoublyLinkedListImplementation(int capacity) {
		this.capacity = capacity;
	}

	Integer get(int key) {
		LRUNode node = map.get(key);
		if (node == null) {
			return -1;
		} else {
			LRUNode previous = node.previous;
			LRUNode next = node.next;

			// if 'node' under consideration is the Last node of the Linked
			// List. Then do nothing.
			if (next == null) {
				return node.data;
			}

			// if 'node' under consideration is the first node of the Linked
			// List.
			if (previous == null) {
				next.previous = null;
				head = next;
			} else {
				previous.next = next;
				next.previous = previous;
			}

			// Add the removed 'node' to the last.
			tail.next = node;
			node.previous = tail;
			node.next = null;
			tail = node;

			return node.data;
		}
	}

	public void put(int key, int value) {
		LRUNode node = map.get(key);
		if (map.get(key) == null) {
			LRUNode newNode = new LRUNode(key, value);
			if (size == 0) {
				head = tail = newNode;
				size++;
			} else if (size < capacity) {
				// Add the new 'node' to the last.
				tail.next = newNode;
				newNode.previous = tail;
				tail = newNode;
				size++;
			} else {
				// Remove the first node of the Linked List.
				LRUNode firstNode = head.next;
				// There is only one Node in the LinkedList
				if (firstNode == null) {
					map.remove(head.key);
					head.key = key;
					head.data = value;
					map.put(key, newNode);
					return;
				}
				firstNode.previous = null;
				map.remove(head.key);
				head = firstNode;

				// Add the new 'node' to the last.
				tail.next = newNode;
				newNode.previous = tail;
				tail = newNode;
			}
			map.put(key, newNode);
		} else {
			LRUNode previous = node.previous;
			LRUNode next = node.next;

			// if 'node' under consideration is the Last node of the Linked
			// List. Then do nothing.
			if (next == null) {
				node.data = value;
				return;
			}

			// if 'node' under consideration is the first node of the Linked
			// List.
			if (previous == null) {
				next.previous = null;
				head = next;
			} else {
				previous.next = next;
				next.previous = previous;
			}

			// Add the removed 'node' to the last.
			node.data = value;
			tail.next = node;
			node.previous = tail;
			node.next = null;
			tail = node;
		}
	}
}