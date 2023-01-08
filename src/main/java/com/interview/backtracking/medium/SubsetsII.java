package com.interview.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
    List<List<Integer>> res = new LinkedList<>();
    int[] arr;

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        this.arr = arr;
        helper(new LinkedList<Integer>(), 0);
        return res;
    }

    private void helper(List<Integer> comb, int index) {
        // Check if we found a combination
        res.add(new ArrayList(comb));


        // DFS all the paths
        for (int i = index; i < arr.length; i++) {

            if (i != index && arr[i] == arr[i - 1]) continue;
            comb.add(arr[i]);
            helper(comb, i + 1);// We can still reuse the same element dfs down the path
            comb.remove(comb.size() - 1);
        }
    }
}





