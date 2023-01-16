package com.interview.dynamic.programming.medium.distinct_ways_pattern;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CombinationSumIVTest {


    CombinationSumIV obj = new CombinationSumIV();

    @Test
    public void combinationSum4TestCase() {
//        public int combinationSum4(int[] nums, int target)

        Assert.assertEquals(7, obj.combinationSum4(new int[]{1, 2, 3}, 4));
    }

}