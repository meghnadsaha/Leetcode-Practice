//package com.interview.dynamic.programming.hard;
//
//import com.interview.dynamic.programming.medium.UniquePathsII;
//import org.junit.Assert;
//import org.junit.Test;
//
//public class UniquePathsIIITest {
//
//    @Test
//    public void testUniquePathsIII1() {
//
//        int[][] obstacleGrid1 = {
//                {1, 0, 0, 0},
//                {0, 0, 1, 0},
//                {0, 0, 2, -1}};
//        UniquePathsIII uniquePathsII = new UniquePathsIII();
//
//        int expectedOutput = 2;
//        int actualOutput = uniquePathsII.uniquePathsIII(obstacleGrid1);
//
//        Assert.assertEquals(expectedOutput, actualOutput);
//
//    }
//
//    @Test
//    public void testUniquePathsIII2() {
//
//        int[][] obstacleGrid1 = {
//                {0, 1},
//                {2, 0}};
//        UniquePathsIII uniquePathsII = new UniquePathsIII();
//
//        int expectedOutput = 2;
//        int actualOutput = uniquePathsII.uniquePathsIII(obstacleGrid1);
//
//        Assert.assertEquals(expectedOutput, actualOutput);
//
//    }
//}
//
//
