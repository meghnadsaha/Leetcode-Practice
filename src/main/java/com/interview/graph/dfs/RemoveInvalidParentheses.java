package com.interview.graph.dfs;

import java.util.*;

/**
 * During the DFS, if the result we are building is still valid, for the current
 * char we have two options:
 * 
 * take it skip it We can brainlessly take any element, because we have
 * validation at each recursion step. The key question is when to skip an
 * element. To meet the requirement of getting valid ones with minimum removal,
 * we should:
 * 
 * Only remove when neccessary. That means, only skip when there is still a
 * misplaced bracket. So we should count the number of misplaced brackets in
 * advance. To speed up:
 * 
 * Don't get a potential result first, then throw it into a Set. This is slow.
 * Avoid duplicate processing in advance. The duplicate results could only be
 * caused by skipping identical elememts.
 * 
 * For xxAAxx, the result is the same if you skip the first or the second A. So,
 * to avoid duplicate in advance:
 * 
 * For xxAAxx, we could only skip the second A if the first A is not skipped.
 * This is to checks.charAt(i) == sb.charAt(sb.length() - 1)
 *
 *https://leetcode.com/problems/remove-invalid-parentheses/solution/
 */
public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList();
		if (s == null)
			return res;

		// count misplaced parentheses
		int left = 0, right = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				left += 1;
			else if (c == ')' && left > 0)
				left -= 1;
			else if (c == ')')
				right += 1;
		}

		dfs(0, new StringBuilder(), 0, left + right, s, res);
		return res;
	}

	private void dfs(int i, StringBuilder sb, int left, int mis, String s, List<String> res) {
		// take when possible
		if (i == s.length() && left == 0) { // complete
			res.add(sb.toString());
		} else if (i < s.length() && left >= 0) { // process while valid
			char c = s.charAt(i);
			int leftChange = c == '(' ? 1 : c == ')' ? -1 : 0;
			sb.append(c);
			dfs(i + 1, sb, left + leftChange, mis, s, res); // take
			sb.deleteCharAt(sb.length() - 1);
			if (mis > 0 && !(sb.length() > 0 && s.charAt(i) == sb.charAt(sb.length() - 1)) && (c == ')' || c == '(')) {
				dfs(i + 1, sb, left, mis - 1, s, res); // skip
			}
		}
	}
}