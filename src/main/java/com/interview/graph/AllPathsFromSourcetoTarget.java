package com.interview.graph;

import java.util.*;
	
public class AllPathsFromSourcetoTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		tmp.add(0);
		helper(res, graph, 0, tmp);
		return res;
	}

	private void helper(List<List<Integer>> res, int[][] graph, int cur, List<Integer> tmp) {
		if (cur == graph.length - 1) {
			res.add(new ArrayList(tmp));
			return;
		}

		for (int i : graph[cur]) {
			tmp.add(i);
			helper(res, graph, i, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}

}
