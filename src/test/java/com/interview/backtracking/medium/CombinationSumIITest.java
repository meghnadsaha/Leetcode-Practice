package com.interview.backtracking.medium;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIITest {

    CombinationSumII combinationSum = new CombinationSumII();

    @Test
    public void combinationSum() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ans.add(new ArrayList<>());
        }
        ans.get(0).add(1);
        ans.get(0).add(1);
        ans.get(0).add(6);
        ans.get(1).add(1);
        ans.get(1).add(2);
        ans.get(1).add(5);
        ans.get(2).add(1);
        ans.get(2).add(7);
        ans.get(3).add(2);
        ans.get(3).add(6);


        Assert.assertEquals(ans, combinationSum.combinationSum(candidates, target));
    }

    @Test
    public void combinationSumTwo() {
        int[] candidates = new int[]{2, 5, 2, 1, 2};
        int target = 5;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<>());
        }
        ans.get(0).add(1);
        ans.get(0).add(2);
        ans.get(0).add(2);
        ans.get(1).add(5);


        Assert.assertEquals(ans, combinationSum.combinationSum(candidates, target));
    }
}