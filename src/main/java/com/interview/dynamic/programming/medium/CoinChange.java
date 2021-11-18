package com.interview.dynamic.programming.medium;

import java.util.Arrays;

/*
		EXAMPLE 1:
			coinChange(coins: [1, 2, 5] amount: 11)
				dp = [0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
				coin: 1 -> [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] minCoins: 11
				coin: 2 -> [0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6] minCoins: 6
				coin: 5 -> [0, 1, 1, 2, 2, 1, 2, 2, 3, 3, 2, 3] minCoins: 3
			RESULT: 3

		EXAMPLE 2:
			coinChange(coins: [3, 5] amount: 7)
				dp = [0, 8, 8, 8, 8, 8, 8, 8]
				coin: 3 -> [0, 8, 8, 1, 8, 8, 2, 8] minCoins: -1
				coin: 5 -> [0, 8, 8, 1, 8, 1, 2, 8] minCoins: -1
			RESULT: -1
		*/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // create an int array of length amount+1
        int[] dp = new int[amount + 1];

        // format the int array for processing
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // update the array with the minimum number of coins needed at each amount
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // return the minimum number of coins needed at the requested amount
        int minCoins = dp[dp.length - 1];
        //If that amount of money cannot be made up by any combination of the coins, return -1.
        return dp[dp.length - 1] == amount + 1 ? -1 : minCoins;
    }
}





