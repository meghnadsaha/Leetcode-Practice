package com.interview.backtracking.medium;


import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsTest {

    Permutations object = new Permutations();

    @Test
    public void testPermute() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(0).add(2);
        list.get(0).add(3);

        list.get(1).add(1);
        list.get(1).add(3);
        list.get(1).add(2);

        list.get(2).add(2);
        list.get(2).add(1);
        list.get(2).add(3);

        list.get(3).add(2);
        list.get(3).add(3);
        list.get(3).add(1);

        list.get(4).add(3);
        list.get(4).add(1);
        list.get(4).add(2);

        list.get(5).add(3);
        list.get(5).add(2);
        list.get(5).add(1);

        System.out.println(object.permute(new int[]{1, 2, 3}));
        System.out.println(list);
    }
}