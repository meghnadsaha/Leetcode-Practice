package com.interview.dynamic.programming;

import java.util.*;

public class ArithmeticSlicesIISubsequence_446 {

	public int numberOfArithmeticSlices(int[] A) {
		int n = A.length;
		int[][] dp = new int[n][n];
		Map<Long, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.putIfAbsent((long) A[i], new ArrayList<Integer>());
			map.get((long) A[i]).add(i);
		}

		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				long target = 2 * (long) A[j] - A[i];
				System.out.println("(2 * A["+j+"]) - A["+i+"] ="+"{2 *"+ A[j]+"}-"+A[i]+" = "+target);

				if (map.containsKey(target)) {
					for (int k : map.get(target)) {
						if (k < j) {
							dp[i][j] += (dp[j][k] + 1);
							System.out.println("dp["+i+"]["+j+"] += (dp["+j+"]["+k+"] + 1) = "+dp[i][j]+"\n");

						}
					}
				}
				res += dp[i][j];
			}
		}
		return res;
	}
}
