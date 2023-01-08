package com.interview.backtracking.medium;

import java.util.LinkedList;
import java.util.List;

public class Permutations {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        helper(list, new LinkedList<>());
        return res;
    }

    private void helper(List<Integer> list, LinkedList<Integer> currentCombination) {
        if (list.isEmpty()) {
            List<Integer> temp = new LinkedList<>(currentCombination);
            res.add(temp);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer val = list.remove(i);
            currentCombination.add(val);
            helper(list, currentCombination);
            //Reverse the changes to get ready for the next iteration
            currentCombination.remove(currentCombination.size() - 1);
            list.add(i, val);
        }
    }

}
