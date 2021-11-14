package com.interview.dynamic.programming.others;

import java.util.*;
/**
 *https://www.youtube.com/watch?v=6s1Y3zSIMbI 
 * 
 * 
 **/

public class ConcatenatedWords_472 {

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> result = new ArrayList<String>();
		Set<String> set = new HashSet<String>();
		for (String s : words) {
			set.add(s);
		}

		for (String s : words) {
			set.remove(s);

			if (canBreak(s, set)) {
				result.add(s);
			}
			set.add(s);
		}
		return result;
	}

	private boolean canBreak(String s, Set<String> set) {
		if (set.size() == 0)
			return false;
		int n = s.length();
		if (n == 0)
			return false;
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (!dp[j])	continue;
				if (set.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];

	}

}
