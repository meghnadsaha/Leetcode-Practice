package com.interview.design;

import java.util.*;

/**
 * Implemented LRU cache using LinkedHashMap of Integer/Integer. No need to use
 * Node object here.
 */
class LinkedHashMapImplementation {

	private int capacity;
	private Map<Integer, Integer> map = new LinkedHashMap<>();

	public LinkedHashMapImplementation(int capacity) {
		this.capacity = capacity;
	}

	Integer get(int key) {
		Integer value = map.get(key);
		if (value == null) {
			return -1;
		} else {
			map.remove(key);
			map.put(key, value);
			return value;
		}
	}

	public void put(int key, int value) {
		if (map.get(key) == null) {
			if (map.size() == capacity) {
				Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
				while (iterator.hasNext()) {
                    Map.Entry<Integer, Integer> element = iterator.next();
				    if (element != null) {
					    iterator.remove();
					    break;
				    }
			    }
            }
			map.put(key, value);
		} else {
			map.remove(key);
			map.put(key, value);
		}
	}
}
