package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;

public class MaximumProductSubarrayTset {

    @Test
    public void testMaxProduct() {

        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();

        int actual = maximumProductSubarray.maxProduct(new int[]{2,3,-2,4});
        int expected = 6;

        Assert.assertEquals(expected, actual);
    }

}
