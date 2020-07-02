package com.interview.graph;

import java.util.*;
	
public class CourseScheduleII {
	
	public int snakesAndLadders(int[][] board) {
		if (board == null || board.length == 0)
			return 0;
		int n = board.length;
		boolean[] used = new boolean[n * n + 1];

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);

		int moves = 0;
		int min = n * n;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				if (cur == n * n) {
					min = Math.min(min, moves);
				}

				for (int j = 1; j <= 6; j++) {
					if (j + cur > n * n)
						break;

					if (!used[j + cur]) {
						used[j + cur] = true;
						int row = n - (j + cur - 1) / n - 1;

						int col = ((n - row) % 2 != 0) ? (j + cur - 1) % n : n - (j + cur - 1) % n - 1;

						if (board[row][col] == cur)
							continue;
						if (board[row][col] == -1) {
							q.offer(j + cur);
						} else {
							q.offer(board[row][col]);
						}
					}
				}
			}

			moves++;
		}

		return min == n * n ? -1 : min;
	}
}