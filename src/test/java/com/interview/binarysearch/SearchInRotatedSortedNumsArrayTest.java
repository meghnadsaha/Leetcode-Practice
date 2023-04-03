package com.interview.binarysearch;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class SearchInRotatedSortedNumsArrayTest extends TestCase {

    SearchInRotatedSortedNumsArray obj = new SearchInRotatedSortedNumsArray();

    @Test
    public void testSearch() {
        Assert.assertEquals(4, obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @Test
    public void testSearchTwo() {
        Assert.assertEquals(-1, obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    @Test
    public void testSearchThree() {
        Assert.assertEquals(-1, obj.search(new int[]{1}, 0));
    }


}