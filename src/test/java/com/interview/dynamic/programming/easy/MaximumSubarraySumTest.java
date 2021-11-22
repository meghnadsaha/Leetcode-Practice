package com.interview.dynamic.programming.easy;

import com.interview.dynamic.programming.hard.UniquePathsIII;
import org.junit.Assert;
import org.junit.Test;

public class MaximumSubarraySumTest {
    @Test
    public void testMaxSubArray1() {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();

        int expectedOutput = 6;
        int actualOutput = maximumSubarraySum.maxSubArray(nums);

        Assert.assertEquals(expectedOutput, actualOutput);

    }
    @Test
    public void testMaxSubArray2() {

        int[] nums = {1};

        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();

        int expectedOutput = 1;
        int actualOutput = maximumSubarraySum.maxSubArray(nums);

        Assert.assertEquals(expectedOutput, actualOutput);

    }
    @Test
    public void testMaxSubArray3() {

        int[] nums = {5,4,-1,7,8};

        MaximumSubarraySum maximumSubarraySum = new MaximumSubarraySum();

        int expectedOutput = 23;
        int actualOutput = maximumSubarraySum.maxSubArray(nums);

        Assert.assertEquals(expectedOutput, actualOutput);

    }
}
