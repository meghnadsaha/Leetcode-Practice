package com.interview.graph.bfs;

import java.util.*;
	
/**
 * https://blog.baozitraining.org/2019/05/leetcode-solution-1036-escape-large-
 * maze.html
 * 
 * Time Complexity: O(N), N = 1M * 1M, essentially need to cover the entire huge
 * grid
 * 
 * Space Complexity: O(N), N = 1M*1M, essentially all the nodes need to be put
 * to visited set
 */

public class TheMazeIII {
	private final int[] xDirection = { 1, 0, -1, 0 };
	private final int[] yDirection = { 0, -1, 0, 1 };
	private final int ONE_MILLION = 1000000;
	private final int MAX_COUNT_THRESHOLD = 20000;

	public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
		if (blocked == null || source == null || target == null) {
			return false;
		}

		Set<String> blockLookup = this.indexBlockedMatrixToSet(blocked);
		boolean isSourceLoop = this.isLoopAroundPoint(source, target, blockLookup);
		if (isSourceLoop) {
			return false;
		}

		boolean isTargetLoop = this.isLoopAroundPoint(target, source, blockLookup);
		if (isTargetLoop) {
			return false;
		}

		return true;
	}

	private boolean isLoopAroundPoint(int[] source, int[] target, Set<String> blockLookup) {
		int count = 0;

		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		String index = source[0] + "," + source[1];
		queue.offer(index);
		visited.add(index);

		while (!queue.isEmpty()) {
			String[] curBlock = queue.poll().split(",");
			int curX = Integer.parseInt(curBlock[0]);
			int curY = Integer.parseInt(curBlock[1]);

			// here think about
			if (count >= MAX_COUNT_THRESHOLD) {
				return false;
			}

			if (curX == target[0] && curY == target[1]) {
				return false;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = curX + xDirection[i];
				int nextY = curY + yDirection[i];

				if (this.shouldExplore(nextX, nextY, ONE_MILLION, ONE_MILLION, blockLookup, visited)) {
					String nextKey = nextX + "," + nextY;
					count++;
					visited.add(nextKey);
					queue.offer(nextKey);
				}
			}
		}

		return true;
	}

	private boolean shouldExplore(int x, int y, int row, int col, Set<String> blockLookup, Set<String> visited) {
		if (!(x >= 0 && x < row && y >= 0 && y < col)) {
			return false;
		}

		String index = x + "," + y;
		if (visited.contains(index)) {
			return false;
		}
		if (blockLookup.contains(index)) {
			return false;
		}

		return true;
	}

	private Set<String> indexBlockedMatrixToSet(int[][] blocked) {
		Set<String> lookup = new HashSet<>();

		for (int i = 0; i < blocked.length; i++) {
			int x = blocked[i][0];
			int y = blocked[i][1];
			String index = x + "," + y;
			lookup.add(index);
		}
		return lookup;
	}
}