package com.interview.dynamic.programming;

/**
 * Substrings are consecutive subsequences. For a n-element sequence of pairwise
 * distinct letters you have n(n+1)/2 non-empty substrings and 2n−1 non-empty
 * subsequences.
 * 
 * For example, for sequence abc we have
 * 
 * substrings: a, ab, abc, b, bc, c, and the empty substring; subsequences: a,b,
 * ab, c, ac, bc, abc, and the empty subsequence.
 * 
 * | 1 (if i = j) LPS[i..j] = | LPS[i+1..j-1] + 2 (if X[i] = X[j]) | max
 * (LPS[i+1..j], LPS[i..j-1]) (if X[i] != X[j])
 */
//https://www.youtube.com/watch?v=PeWSAIN2TNc&feature=youtu.be
public class LongestPalindromicSubsequence_516 {
	public static void print2D(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) { // this equals to the row in
													// our matrix.
			for (int j = 0; j < matrix[i].length; j++) { // this equals to the
															// column in each
															// row.
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(); // change line on console as row comes to end
									// in the matrix.
		}
	}

	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];

		for (int i = n - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		print2D(dp);
		return dp[0][n - 1];// The Whole String
	}
}
