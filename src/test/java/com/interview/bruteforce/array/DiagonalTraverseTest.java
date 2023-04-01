package com.interview.bruteforce.array;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DiagonalTraverseTest extends TestCase {

    DiagonalTraverse obj = new DiagonalTraverse();

    @Test
    public void testFindDiagonalOrder() {
        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] expected = new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9};
        int[] actual = obj.findDiagonalOrder(input);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindDiagonalOrderOne() {
        int[][] input = new int[][]{{1, 2}, {3, 4}};
        int[] expected = new int[]{1, 2, 3, 4};
        int[] actual = obj.findDiagonalOrder(input);
        Assert.assertArrayEquals(expected, actual);
    }
}