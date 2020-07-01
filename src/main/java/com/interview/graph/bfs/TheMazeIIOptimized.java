package com.interview.graph.bfs;

import java.util.Arrays;

import com.interview.common.CommonUtility;

/**
 * https://massivealgorithms.blogspot.com/2019/02/leetcode-505-maze-ii.html
 * 
 * There is a ball in a maze with empty spaces and walls. The ball can go
 * through empty spaces by rolling up, down, left or right, but it won't stop
 * rolling until hitting a wall. When the ball stops, it could choose the next
 * direction. Given the ball's start position, the destination and the maze,
 * find the shortest distance for the ball to stop at the destination. The
 * distance is defined by the number of empty spaces traveled by the ball from
 * the start position (excluded) to the destination (included). If the ball
 * cannot stop at the destination, return -1. The maze is represented by a
 * binary 2D array. 1 means the wall and 0 means the empty space. You may assume
 * that the borders of the maze are all walls. The start and destination
 * coordinates are represented by row and column indexes.
 * 
 * TheMazeIIOptimized Time complexity : O((mn)^2). Complete traversal of maze will be
 * done in the worst case and function minDistance takes O(mn) time.
 */

public class TheMazeIIOptimized {

	public int shortestDistance(int[][] maze, int[] start, int[] dest) {
		int[][] distance = new int[maze.length][maze[0].length];
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		for (int[] row : distance)
			Arrays.fill(row, Integer.MAX_VALUE);
		/**
		 * 1. Assign a tentative distance value to every node: set it to zero
		 * for our start node and to infinity for all other nodes.
		 * 
		 * 2. Set the start node as current node. Mark it as visited.
		 */
		distance[start[0]][start[1]] = 0;
		dijkstra(maze, distance, visited);
		// CommonUtility.print2D(distance);
		// System.out.println(Arrays.toString(dest));
		return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
	}

	/**
	 * 3.
	 * 
	 * I. For the current node, consider all of its neighbors and calculate
	 * their tentative distances.
	 * 
	 * II. Compare the newly calculated tentative distance to the current
	 * assigned value and assign the smaller one to all the neighbors.
	 * 
	 * For example, if the current node A is marked with a distance of 6, and
	 * the edge connecting it with a neighbor B has length 2, then the distance
	 * to B (through A) will be 6 + 2 = 8. If B was previously marked with a
	 * distance greater than 8 then change it to 8.
	 * 
	 * Otherwise, keep the current value.
	 */
	public int[] minDistance(int[][] distance, boolean[][] visited) {
		int[] min = { -1, -1 };
		int min_val = Integer.MAX_VALUE;
		for (int i = 0; i < distance.length; i++) {
			for (int j = 0; j < distance[0].length; j++) {
				if (!visited[i][j] && distance[i][j] < min_val) {
					min = new int[] { i, j };
					min_val = distance[i][j];
				}
			}
		}
		return min;
	}

	public void dijkstra(int[][] maze, int[][] distance, boolean[][] visited) {
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		while (true) {
			int[] s = minDistance(distance, visited);
			if (s[0] < 0)
				break;
			/**
			 * 5. When we are done considering all of the neighbors of the
			 * current node, mark the current node as visited. A visited node
			 * will never be checked again.
			 * 
			 * 6. If the destination node has been marked visited or if the
			 * smallest tentative distance among all the nodes left is
			 * infinity(indicating that the destination can't be reached), then
			 * stop. The algorithm has finished.
			 */
			visited[s[0]][s[1]] = true;
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
				}
			}
		}
	}

}