package com.interview.dynamic.programming.medium.distinct_ways_pattern;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CoinChangeIITest {

    CoinChangeII coinChangeII = new CoinChangeII();

    @Test
    public void coinChangeIITest() {
        int amount = 5;
        int[] coins = {1, 2, 5};
        int actualOutput = coinChangeII.change(amount, coins);
        Assert.assertEquals(2, actualOutput);
    }


}