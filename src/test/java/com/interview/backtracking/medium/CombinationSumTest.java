package com.interview.backtracking.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTest {

    CombinationSum combinationSum = new CombinationSum();

    @Test
    public void combinationSum() {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<>());
        }
        ans.get(0).add(2);
        ans.get(0).add(2);
        ans.get(0).add(3);
        ans.get(1).add(7);

        Assert.assertEquals(ans, combinationSum.combinationSum(candidates, target));
    }

    @Test
    public void combinationSumTwo() {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ans.add(new ArrayList<>());
        }
        ans.get(0).add(2);
        ans.get(0).add(2);
        ans.get(0).add(2);
        ans.get(0).add(2);

        ans.get(1).add(2);
        ans.get(1).add(3);
        ans.get(1).add(3);

        ans.get(2).add(3);
        ans.get(2).add(5);


        Assert.assertEquals(ans, combinationSum.combinationSum(candidates, target));
    }

}