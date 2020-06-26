package com.interview.backtracking;

import java.util.*;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0)
			return res;
		helper(res, new ArrayList<>(), candidates, 0, target, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int sum, int target, int index) {
		if (sum == target) {
			res.add(new ArrayList(tmp));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] + sum <= target) {
				tmp.add(candidates[i]);
				helper(res, tmp, candidates, sum + candidates[i], target, i);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
