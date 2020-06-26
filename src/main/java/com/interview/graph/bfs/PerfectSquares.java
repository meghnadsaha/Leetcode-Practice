package com.interview.graph.bfs;

import java.util.Arrays;

//First do coin change problem
public class PerfectSquares {
	public int numSquares(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0] = 0;
		int i = 0;
		while (++i * i <= n) {
			for (int j = i * i; j < memo.length; j++) {
				memo[j] = Math.min(memo[j], memo[j - (i * i)] + 1);
			}
		}
		return memo[n];

	}
}