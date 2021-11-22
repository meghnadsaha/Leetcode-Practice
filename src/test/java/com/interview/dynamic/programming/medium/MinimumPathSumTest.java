package com.interview.dynamic.programming.medium;

import com.interview.dynamic.programming.others.PalindromePartitioningII_132;
import org.junit.Assert;
import org.junit.Test;

public class MinimumPathSumTest {

    @Test
    public void test() {

        int grid[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int actual = minimumPathSum.minPathSum(grid);
        int expected = 7;

        Assert.assertEquals(expected, actual);
    }

}


