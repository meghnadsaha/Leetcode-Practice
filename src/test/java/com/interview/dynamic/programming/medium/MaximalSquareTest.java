package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;


public class MaximalSquareTest {

    @Test
    public void testMaximalSquare() {

        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//      char[][] matrix = {{'0', '1'}, {'1', '0'}};int expectedOutput = 1;
//      char[][] matrix = {{'0'}};int expectedOutput = 0;


        MaximalSquare maximalSquare = new MaximalSquare();

        int expectedOutput = 4;
        int actualOutput = maximalSquare.maximalSquare(matrix);

        Assert.assertEquals(expectedOutput, actualOutput);
    }





}
