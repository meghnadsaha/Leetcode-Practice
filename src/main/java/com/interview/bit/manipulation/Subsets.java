package com.interview.bit.manipulation;

import java.util.*;

public class Subsets {

    List<List<Integer>> res = new LinkedList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        helper(new LinkedList<Integer>(), 0);
        return res;
    }

    private void helper(List<Integer> comb, int index) {
        // Check if we found a combination
        res.add(new ArrayList(comb));

        // DFS all the paths
        for (int i = index; i < nums.length; i++) {
            comb.add(nums[i]);
            helper(comb, i + 1);// We can still reuse the same element dfs down the path
            comb.remove(comb.size() - 1);
        }
    }


}