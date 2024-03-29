package com.interview.graph.others;

import java.util.*;
	
/**
 * Problem :
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 * discuss/197668/Count-the-Number-of-Islands-O(N)
 *  
 * @author Meghnad Saha
 *
 */
public class MostStonesRemovedwithSameRoworColumn {

	Map<Integer, Integer> f = new HashMap<>();
	int islands = 0;

	public int removeStones(int[][] stones) {
		for (int i = 0; i < stones.length; ++i)
			union(stones[i][0], ~stones[i][1]);
		return stones.length - islands;
	}

	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			f.put(x, y);
			islands--;
		}
	}

	private int find(int x) {
		if (f.putIfAbsent(x, x) == null)
			islands++;
		if (x != f.get(x))
			f.put(x, find(f.get(x)));
		return f.get(x);
	}

}
