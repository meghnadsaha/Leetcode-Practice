package com.interview.heap;

import com.interview.heap.medium.KthSmallestElementInASortedMatrix;
import org.junit.Assert;
import org.junit.Test;

public class KthSmallestElementInASortedMatrixTest {
    @Test
    public void testDifferentCases() {

        KthSmallestElementInASortedMatrix kthSmallestElementInASortedMatrix = new KthSmallestElementInASortedMatrix();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        int outPut = kthSmallestElementInASortedMatrix.kthSmallest(matrix, k);
        Assert.assertEquals(13, outPut);
    }
    @Test
    public void testDifferentCases2() {

        KthSmallestElementInASortedMatrix kthSmallestElementInASortedMatrix = new KthSmallestElementInASortedMatrix();
        int[][] matrix = {{-5}};
        int k = 1;
        int outPut = kthSmallestElementInASortedMatrix.kthSmallest(matrix, k);
        Assert.assertEquals(-5, outPut);
    }

}