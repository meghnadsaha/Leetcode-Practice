package com.interview.graph.dfs;
	
public class LongestIncreasingPathinaMatrix {
	int[][] DIRECTIONS = { { 1, 0 }, // down
			{ -1, 0 }, // up
			{ 0, 1 }, // right
			{ 0, -1 }// left
	};

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[][] dp = new int[matrix.length][matrix[0].length];

		int max = 0;
		int prev = Integer.MIN_VALUE;

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				max = Math.max(max, dfs(matrix, i, j, prev, dp));

		return max;
	}

	public int dfs(int[][] matrix, int row, int col, int prev, int[][] dp) {

		if (prev >= matrix[row][col])
			return 0;

		if (dp[row][col] != 0)
			return dp[row][col];

		int max = 0;
		for (int[] mv : DIRECTIONS) {
			int tmpRow = row + mv[0];
			int tmpCol = col + mv[1];

			if (tmpRow >= 0 && tmpRow < matrix.length && tmpCol >= 0 && tmpCol < matrix[0].length)
				max = Math.max(max, dfs(matrix, tmpRow, tmpCol, matrix[row][col], dp));
		}

		dp[row][col] = max + 1;
		return dp[row][col];
	}
}