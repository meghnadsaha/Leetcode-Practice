package com.interview.design;

import java.util.*;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Implemented LRU cache using Java built-in LinkedList of LRUDataNode and
 * HashMap
 */
public class LRUCache {

	private int capacity;
	private LinkedList<LRUDataNode> list = new LinkedList<>();
	private Map<Integer, LRUDataNode> map = new HashMap<>();

	/**
	 * Node class containing Key/Value.
	 */
	class LRUDataNode {
		int key;
		int data;

		LRUDataNode(int key, int data) {
			this.key = key;
			this.data = data;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof LRUDataNode) {
				return (key == ((LRUDataNode) obj).key && data == ((LRUDataNode) obj).data);
			}
			return false;
		}
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		LRUDataNode node = map.get(key);
		if (node == null) {
			return -1;
		} else {
			list.remove(node);
			list.addLast(node);
			return node.data;
		}
	}

	public void put(int key, int value) {
		if (map.get(key) == null) {
			if (list.size() == capacity) {
				map.remove(list.remove(0).key);
			}
			LRUDataNode node = new LRUDataNode(key, value);
			list.addLast(node);
			map.put(key, node);
		} else {
			LRUDataNode node = map.get(key);
			list.remove(node);
			node.data = value;
			list.addLast(node);
			map.put(key, node);
		}
	}
}
