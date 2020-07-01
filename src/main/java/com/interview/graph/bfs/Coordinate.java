package com.interview.graph.bfs;

/**
 * The idea is just using BFS with a PriorityQueue(dijkstra's algorithm),
 * PriorityQueue polls out the Coordinate with the minimum distance, if there
 * are two with same distance, we compare their lexicographical order, by this
 * way, we can ensure that we get the lexicographically smallest way in the end.
 */
public class Coordinate implements Comparable<Coordinate> {

	int x, y, dist;
	String moves;

	public Coordinate(int x, int y, int dist, String moves) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.moves = moves;
	}

	@Override
	public int compareTo(Coordinate that) {
		if (this.dist != that.dist)
			return this.dist - that.dist;
		return this.moves.compareTo(that.moves);
	}

}
