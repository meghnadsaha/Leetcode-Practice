package com.interview.dynamic.programming;

import java.util.*;

/**
 * https://github.com/happygirlzt/algorithm-illustrations
 * https://leetcode.com/problems/longest-string-chain/submissions/
 */
public class LongestStringChain_1048 {
	public int longestStrChain(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		List<String>[] wordList = new List[17];
		for (String word : words) {
			int len = word.length();
			if (wordList[len] == null) {
				wordList[len] = new ArrayList<>();
			}
			wordList[len].add(word);
			map.put(word, 1);
		}
		int max = 1;
		for (int len = 1; len < 17; len++) {
			if (wordList[len] == null)
				continue;
			for (String word : wordList[len]) {
				int preLen = len - 1;
				if (wordList[preLen] == null)
					continue;
				for (String preWord : wordList[preLen]) {
					if (isPre(preWord, word)) {
						map.put(word,
								Math.max(map.get(word),
										map.get(preWord) + 1));
						max = Math.max(max, map.get(word));
					}
				}
			}

		}

		return max;

	}

	private boolean isPre(String w1, String w2) {
		int p1 = 0, p2 = 0;
		boolean found = false;
		while (p1 < w1.length() && p2 < w2.length()) {
			if (w1.charAt(p1) == w2.charAt(p2)) {
				p1++;
				p2++;
			} else if (found) {
				return false;
			} else {
				found = true;
				p2++;
			}
		}
		return true;
	}
}
