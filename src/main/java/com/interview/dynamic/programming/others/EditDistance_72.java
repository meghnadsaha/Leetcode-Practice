package com.interview.dynamic.programming.others;

import java.util.Arrays;

public class EditDistance_72 {
	  public int minDistance(String word1, String word2) {
			// read
			// hi
			// 1 . rea + 1
			// hi
			// 2. read + 1
			// h
			// 3. rea
			// h + 1
			// word1 -> word2

			int m = word1.length();
			int n = word2.length();
			int[][] dp = new int[m + 1][n + 1];
			for (int i = 0; i <= m; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
				dp[i][0] = i;
			}

			for (int j = 0; j <= n; j++) {
				dp[0][j] = j;
			}
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (word1.charAt(i)==word2.charAt(j)) {
						dp[i+1][j+1]=dp[i][j];
					}else{
						dp[i+1][j+1] =Math.min(dp[i + 1][j],
											 Math.min(dp[i][j + 1],
												      dp[i][j]) )+ 1;

					}
				}
			}
			return dp[m][n];

		}

	
}
