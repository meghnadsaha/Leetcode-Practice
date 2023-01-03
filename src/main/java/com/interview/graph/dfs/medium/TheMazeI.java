package com.interview.graph.dfs.medium;

import java.util.PriorityQueue;
	
public class TheMazeI {

	int[][] dirs = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
	char[] dirc = { 'd', 'l', 'r', 'u' };

	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		int m = maze.length, n = maze[0].length;

		boolean[][] visited = new boolean[m][n];

		PriorityQueue<Coordinate> pq = new PriorityQueue<>();
		pq.add(new Coordinate(ball[0], ball[1], 0, ""));

		while (!pq.isEmpty()) {
			Coordinate curr = pq.poll();

			if (curr.x == hole[0] && curr.y == hole[1]) {
				return curr.moves;
			}

			if (!visited[curr.x][curr.y]) {
				visited[curr.x][curr.y] = true;
				for (int direction = 0; direction < 4; direction++) {
					Coordinate next = moveForward(maze, curr, direction, hole);
					pq.add(new Coordinate(next.x, next.y, next.dist, next.moves + dirc[direction]));
				}
			}
		}
		return "impossible";
	}

	/*
	 * Start from current position move forward in one direction until hit the
	 * wall, return the last position before hitting the wall
	 */
	private Coordinate moveForward(int[][] maze, Coordinate curr, int direction, int[] hole) {
		int m = maze.length, n = maze[0].length;
		int nx = curr.x, ny = curr.y, dis = curr.dist;
		while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
			nx += dirs[direction][0];
			ny += dirs[direction][1];
			dis++;
			if (nx == hole[0] && ny == hole[1]) {
				return new Coordinate(nx, ny, dis, curr.moves);
			}
		}
		// back up one step from wall
		nx -= dirs[direction][0];
		ny -= dirs[direction][1];
		dis--;
		return new Coordinate(nx, ny, dis, curr.moves);
	}
}