package com.interview.backtracking;

import java.util.*;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 1)
			return res;
		helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] visited) {
		if (cur.size() == nums.length) {
			res.add(new ArrayList(cur));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i])
				continue;
			cur.add(nums[i]);
			visited[i] = true;
            helper(res, cur, nums, visited);
            cur.remove(cur.size() - 1);
            visited[i] = false;
		}
	}

}
