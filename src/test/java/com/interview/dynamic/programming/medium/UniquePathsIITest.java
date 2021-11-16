package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;

public class UniquePathsIITest {

    @Test
    public void testUniquePathsWithObstacles1() {

        int[][] obstacleGrid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();

        int expectedOutput = 2;
        int actualOutput = uniquePathsII.uniquePathsWithObstacles(obstacleGrid1);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUniquePathsWithObstacles2() {

        int[][] obstacleGrid1 = {
                {0, 1},
                {0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();

        int expectedOutput = 1;
        int actualOutput = uniquePathsII.uniquePathsWithObstacles(obstacleGrid1);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUniquePathsWithObstacles3() {

        int[][] obstacleGrid1 = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();

        int expectedOutput = 11;
        int actualOutput = uniquePathsII.uniquePathsWithObstacles(obstacleGrid1);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUniquePathsWithObstacles4() {

        int[][] obstacleGrid1 = {
                {0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();

        int expectedOutput = 10;
        int actualOutput = uniquePathsII.uniquePathsWithObstacles(obstacleGrid1);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testUniquePathsWithObstacles5() {

        int[][] obstacleGrid1 = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();

        int expectedOutput = 2;
        int actualOutput = uniquePathsII.uniquePathsWithObstacles(obstacleGrid1);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

}


