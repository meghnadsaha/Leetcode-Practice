package com.interview.dynamic.programming.medium.distinct_ways_pattern;

import com.interview.greedy.medium.bfs.JumpGameII;
import org.junit.Assert;
import org.junit.Test;


public class DecodeWaysTest  {

    @Test
    public void testNumDecodings() {
        DecodeWays decodeWays = new DecodeWays();
        int actualOutput = decodeWays.numDecodings("12");
        Assert.assertEquals(2, actualOutput);
    }

    @Test
    public void testNumDecodings226() {
        DecodeWays decodeWays = new DecodeWays();
        int actualOutput = decodeWays.numDecodings("226");
        Assert.assertEquals(3, actualOutput);
    }

    @Test
    public void testNumDecodings06() {
        DecodeWays decodeWays = new DecodeWays();
        int actualOutput = decodeWays.numDecodings("06");
        Assert.assertEquals(0, actualOutput);
    }

}