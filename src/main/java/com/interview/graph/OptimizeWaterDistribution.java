package com.interview.graph;

import java.util.*;
	
/**
 * https://github.com/azl397985856/leetcode/blob/master/problems/1168.optimize-
 * water-distribution-in-a-village-en.md
 * 
 * Time Complexity: O(ElogE) - E number of edge in graph Space Complexity: O(E)
 * 
 * 1.Build graph with all possible edges. 2.Sort edges by value (costs)
 * 3.Iterate all edges (from min value to max value) 4.For each edges, check
 * whether two nodes already connected (union-find), if already connected, then
 * skip if not connected, then union two nodes, add costs to result
 **/

public class OptimizeWaterDistribution {

	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		List<EdgeCost> costs = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			costs.add(new EdgeCost(0, i, wells[i - 1]));
		}
		for (int[] p : pipes) {
			costs.add(new EdgeCost(p[0], p[1], p[2]));
		}
		Collections.sort(costs);
		int minCosts = 0;
		UnionFind uf = new UnionFind(n);
		for (EdgeCost edge : costs) {
			int rootX = uf.find(edge.node1);
			int rootY = uf.find(edge.node2);
			if (rootX == rootY)
				continue;
			minCosts += edge.cost;
			uf.union(edge.node1, edge.node2);
			// for each union, we connnect one node
			n--;
			// if all nodes already connected, terminate early
			if (n == 0) {
				return minCosts;
			}
		}
		return minCosts;
	}

}

class EdgeCost implements Comparable<EdgeCost> {
	int node1;
	int node2;
	int cost;

	public EdgeCost(int node1, int node2, int cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}

	@Override
	public int compareTo(EdgeCost o) {
		return this.cost - o.cost;
	}
}

class UnionFind {
	int[] parent;
	int[] rank;

	public UnionFind(int n) {
		parent = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		rank = new int[n + 1];
	}

	/**
	 * For each edges, check whether two nodes already connected (union-find),
	 * if already connected, then skip if not connected, then union two nodes,
	 * add costs to result
	 */
	public int find(int x) {
		return x == parent[x] ? x : find(parent[x]);
	}

	public void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px == py)
			return;
		if (rank[px] >= rank[py]) {
			parent[py] = px;
			rank[px] += rank[py];
		} else {
			parent[px] = py;
			rank[py] += rank[px];
		}
	}
}