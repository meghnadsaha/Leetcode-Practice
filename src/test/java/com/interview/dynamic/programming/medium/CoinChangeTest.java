package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;



public class CoinChangeTest {
    @Test
    public void testCoinChange1() {

        int[] coins = {1, 2, 5};
        int amount = 11;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = 3;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCoinChange2() {

        int[] coins = {2};
        int amount = 3;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = -1;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCoinChange3() {

        int[] coins = {1};
        int amount = 0;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = 0;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCoinChange4() {

        int[] coins = {1};
        int amount = 2;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = 2;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void testCoinChange5() {

        int[] coins = {1, 2, 5};
        int amount = 5;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = 1;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testCoinChange6() {

        int[] coins = {1, 3, 5, 7 };
        int amount = 8;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = 2;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCoinChange7() {

        int[] coins = {1,2,3,4,5};
        int amount = 16;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = 4;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testCoinChange8() {

        int[] coins = {1,2,5,9,8};
        int amount = 17;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = 2;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCoinChange9() {

        int[] coins = {2, 4, 6, 8};
        int amount = 15;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = -1;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testCoinChange10() {

        int[] coins = {1,5};
        int amount = 11;

        CoinChange coinChange = new CoinChange();

        int expectedOutput = 3;
        int actualOutput = coinChange.coinChange(coins, amount);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

}
