package com.interview.sorting.medium;

import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutiveSequenceTest {

    LongestConsecutiveSequenceUsingSorting obj = new LongestConsecutiveSequenceUsingSorting();

    @Test
    public void testLongestConsecutive() {
        Assert.assertEquals(4, obj.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    @Test
    public void testLongestConsecutive2() {
        Assert.assertEquals(9, obj.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}