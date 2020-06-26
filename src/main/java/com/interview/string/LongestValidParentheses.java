package com.interview.string;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {

		int[] dp = new int[s.length()];
		int maxLength = 0;
		char[] str = s.toCharArray();

		for (int i = 1; i < dp.length; i++) {
			if (str[i] == ')') {

				int prevOp = i - dp[i - 1] - 1;
				if (prevOp >= 0 && str[prevOp] == '(') {
					dp[i] = 2 + dp[i - 1];

					if (prevOp > 0)
						dp[i] += dp[prevOp - 1];
				}
			}

			maxLength = Math.max(maxLength, dp[i]);
		}

		return maxLength;
	}

}
