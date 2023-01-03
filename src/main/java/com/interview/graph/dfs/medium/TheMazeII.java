package com.interview.graph.dfs.medium;

import java.util.Arrays;
import java.util.PriorityQueue;
	
/**
 * https://massivealgorithms.blogspot.com/2019/02/leetcode-505-maze-ii.html
 * Using Dijkstra Algorithm and Priority Queue[Accepted]
 * 
 * Time complexity : O(mn*log(mn))
 * 
 * Why using PriorityQueue?
 * 
 * We can consider this question as a shortest-route graph problem, that is,
 * each stoppable point is a vertical, where every possible path between two
 * nodes is an edge. In this way, we can using Dijkstra algorithm to solve this
 * problem, and that's why we use PriorityQueue.
 * 
 */

public class TheMazeII {
	public int shortestDistance(int[][] maze, int[] start, int[] dest) {
		int[][] distance = new int[maze.length][maze[0].length];
		for (int[] row : distance)
			Arrays.fill(row, Integer.MAX_VALUE);
		distance[start[0]][start[1]] = 0;
		dijkstra(maze, start, distance);
		return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	}

	public void dijkstra(int[][] maze, int[] start, int[][] distance) {
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		queue.offer(new int[] { start[0], start[1], 0 });
		while (!queue.isEmpty()) {
			int[] s = queue.poll();
			if (distance[s[0]][s[1]] < s[2])
				continue;
			for (int[] dir : dirs) {
				int x = s[0] + dir[0];
				int y = s[1] + dir[1];
				int count = 0;
				while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
					x += dir[0];
					y += dir[1];
					count++;
				}
				if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
					distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
					queue.offer(new int[] { x - dir[0], y - dir[1], distance[x - dir[0]][y - dir[1]] });
				}
			}
		}
	}
}
