package com.interview.design;

import java.util.*;

public class Trie {

	private TrieNode root;

	static class TrieNode {
		char c;
		Map<Character, TrieNode> charMap = new HashMap<Character, TrieNode>();
		boolean isLeaf;
	}

	/** Initialize your data structure here. */
	public Trie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode p = root;
		for (char c : word.toCharArray()) {
			if (!p.charMap.containsKey(c)) {
				TrieNode node = new TrieNode();
				node.c = c;
				p.charMap.put(c, node);
			}
			p = p.charMap.get(c);
		}
		p.isLeaf = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode p = root;
		for (char c : word.toCharArray()) {
			if (!p.charMap.containsKey(c)) {
				return false;
			}
			p = p.charMap.get(c);
		}
		return p.isLeaf;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode p = root;
		for (char c : prefix.toCharArray()) {
			if (!p.charMap.containsKey(c)) {
				return false;
			}
			p = p.charMap.get(c);
		}
		return true;
	}
}
