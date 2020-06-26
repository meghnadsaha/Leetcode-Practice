package com.interview.backtracking;

import java.util.*;

public class WordBreakII {

	public List<String> wordBreak(String s, List<String> aList) {

		Set<String> wordDict = new HashSet<String>();
		for (String x : aList)
			wordDict.add(x);

		HashMap<Integer, List<String>> memo = new HashMap<>(); // <Starting
																// index, rst
																// list>
		return dfs(s, 0, wordDict, memo);
	}

	private List<String> dfs(String s, int start, Set<String> dict, HashMap<Integer, List<String>> memo) {
		if (memo.containsKey(start)) {
			return memo.get(start);
		}

		List<String> rst = new ArrayList<>();
		if (start == s.length()) {
			rst.add("");
			return rst;
		}

		String curr = s.substring(start);
		for (String word : dict) {
			if (curr.startsWith(word)) {
				List<String> sublist = dfs(s, start + word.length(), dict, memo);
				for (String sub : sublist) {
					rst.add(word + (sub.isEmpty() ? "" : " ") + sub);
				}
			}
		}

		memo.put(start, rst);
		return rst;
	}
}
