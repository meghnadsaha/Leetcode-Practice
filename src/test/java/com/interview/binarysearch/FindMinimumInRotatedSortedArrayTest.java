package com.interview.binarysearch;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class FindMinimumInRotatedSortedArrayTest extends TestCase {
    @Test
    public void testFindMin() {
        Assert.assertEquals(1, new FindMinimumInRotatedSortedArray().findMin(new int[]{3, 4, 5, 1, 2}));
    }
    @Test
    public void testFindMinTwo() {
        Assert.assertEquals(0, new FindMinimumInRotatedSortedArray().findMin(new int[]{4,5,6,7,0,1,2}));
    }
    @Test
    public void testFindMinThree() {
        Assert.assertEquals(11, new FindMinimumInRotatedSortedArray().findMin(new int[]{11,13,15,17}));
    }
}