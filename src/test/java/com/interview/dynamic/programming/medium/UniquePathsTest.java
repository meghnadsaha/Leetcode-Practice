package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsTest {

    @Test
    public void testUniquePathsWithObstacles1() {

        int m = 3, n = 2;
        UniquePaths uniquePaths = new UniquePaths();
        int expectedOutput = 3;
        int actualOutput = uniquePaths.uniquePaths(m, n);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUniquePathsWithObstacles2() {

        int m = 7, n = 3;
        UniquePaths uniquePaths = new UniquePaths();
        int expectedOutput = 28;
        int actualOutput = uniquePaths.uniquePaths(m, n);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUniquePathsWithObstacles3() {

        int m = 3, n = 3;
        UniquePaths uniquePaths = new UniquePaths();
        int expectedOutput = 6;
        int actualOutput = uniquePaths.uniquePaths(m, n);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

}


