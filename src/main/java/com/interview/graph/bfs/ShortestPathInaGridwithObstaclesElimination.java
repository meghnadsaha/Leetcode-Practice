package com.interview.graph.bfs;

import java.util.*;

public class ShortestPathInaGridwithObstaclesElimination {
	private static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int shortestPath(int[][] grid, int k) {
		int m = grid.length, n = grid[0].length;
		int[][] seen = new int[m][n];

		for (int i = 0; i < m; i++) {
			Arrays.fill(seen[i], Integer.MAX_VALUE);
		}
		seen[0][0] = 0;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0, 0 });

		int steps = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int row = cur[0], col = cur[1];
				if (row == m - 1 && col == n - 1)
					return steps;

				for (int[] d : dirs) {
					int r = row + d[0], c = col + d[1];
					if (r >= 0 && r < m && c >= 0 && c < n) {
						//If obstacle then increment by +1 
						//If empty then increment by +0
						int o = cur[2] + grid[r][c];
						if (o >= seen[r][c] || o > k)
							continue;

						seen[r][c] = o;
						q.offer(new int[] { r, c, o });
					}
				}
			}
			steps++;
		}
		return -1;
	}
}
