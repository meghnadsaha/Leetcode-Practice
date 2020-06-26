package com.interview.string;

public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		int count = 0, n = s.length();
		int[][] dp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			dp[i][i] = 1;
			count++;
			for (int j = n - 1; j > i; j--) {
				if (s.charAt(i) == s.charAt(j) && (dp[i][j - 1] == 1 || dp[i + 1][j - 1] == 1)) {
					dp[i][j] = 1;
					count++;
				}
			}
		}
		return count;
	}

}
