package com.interview.dynamic.programming.others;

import java.util.Arrays;

public class PalindromePartitioningII_132 {

	public int minCut(String s) {
		int n = s.length();
		boolean[][] isPal = new boolean[n + 1][n + 1];
		computeAllPals(isPal, s.toCharArray());

		int[] minPalindrom = new int[n + 2];
		Arrays.fill(minPalindrom, Integer.MAX_VALUE);
		minPalindrom[n + 1] = 0;

		for (int k = n; k >= 1; k--) {
			for (int l = k; l <= n; l++) {
				if (isPal[k][l]) {
					minPalindrom[k] = Math.min(minPalindrom[k], 
												1 + minPalindrom[l + 1]);
				}
			}
		}
		return minPalindrom[1] - 1;
	}

	private void computeAllPals(boolean[][] isPal, char[] A) {
		int n = A.length;
		for (int i = n; i >= 1; i--) {
			isPal[i][i - 1] = true;
			isPal[i][i] = true;

			for (int j = i + 1; j <= n; j++) {
				if (A[i - 1] == A[j - 1]) {
					isPal[i][j] = isPal[i + 1][j - 1];
				} else {
					isPal[i][j] = false;
				}
			}
		}
	}

}
