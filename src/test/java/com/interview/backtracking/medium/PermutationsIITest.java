package com.interview.backtracking.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIITest {


    PermutationsII object = new PermutationsII();

    @Test
    public void permuteUniqueTest() {
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }

        System.out.println(object.permuteUnique(nums));
    }

    @Test
    public void permuteUniqueTestCaseTwo() {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(object.permuteUnique(nums));
    }
}