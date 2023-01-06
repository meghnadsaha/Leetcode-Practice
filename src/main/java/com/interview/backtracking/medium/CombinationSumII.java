package com.interview.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {

    List<List<Integer>> res = new LinkedList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        helper(target, new LinkedList<Integer>(), 0);
        return res;
    }

    private void helper(int target, List<Integer> comb, int index) {
        // Check if we found a combination
        if (target == 0) {
            res.add(new ArrayList(comb));
            return;
        }

        // DFS all the paths
        for (int i = index; i < candidates.length; i++) {

            if (i != index && candidates[i] == candidates[i - 1])
                continue;

            int curSum = target - candidates[i];
            // Check if out of bound
            if (curSum < 0) continue;
            comb.add(candidates[i]);
            helper(curSum, comb, i+1);// We can still reuse the same element dfs down the path
            comb.remove(comb.size() - 1);
        }
    }
}


