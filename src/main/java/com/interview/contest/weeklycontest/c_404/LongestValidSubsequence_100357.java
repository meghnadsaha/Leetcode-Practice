package com.interview.contest.weeklycontest.c_404;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class LongestValidSubsequence_100357 {

    //https://leetcode.com/contest/weekly-contest-404/problems/find-the-maximum-length-of-valid-subsequence-i/description/
    public int maximumLength ( int[] nums ) {
        int n = nums.length;
        int oddIdx = n, evenIdx = n, maxLength = 0;
        int[][] dp = new int[n][2]; // dp[i][0] for sum % 2 == 0, dp[i][1] for sum % 2 == 1

        // Initialize dp array
        for (int i = 0 ; i < n ; i++) {
            Arrays.fill(dp[i] , 1);
        }

        for (int i = n - 1 ; i >= 0 ; i--) {
            if (nums[i] % 2 == 1) { // odd number
                if (evenIdx != n) {
                    dp[i][1] += dp[evenIdx][1];
                }
                if (oddIdx != n) {
                    dp[i][0] += dp[oddIdx][0];
                }
                oddIdx = i;
            } else { // even number
                if (oddIdx != n) {
                    dp[i][1] += dp[oddIdx][1];
                }
                if (evenIdx != n) {
                    dp[i][0] += dp[evenIdx][0];
                }
                evenIdx = i;
            }
            maxLength = Math.max(maxLength , Math.max(dp[i][0] , dp[i][1]));
        }

        return maxLength;
    }

    @Test
    public void testMaximumLength1 () {

        LongestValidSubsequence_100357 longestValidSubsequence = new LongestValidSubsequence_100357();

        int[] nums = {1 , 2 , 3 , 4};
        assertEquals(4 , longestValidSubsequence.maximumLength(nums));

        int[] nums1 = {1 , 2 , 1 , 1 , 2 , 1 , 2};
        assertEquals(61 , longestValidSubsequence.maximumLength(nums1));

        int[] nums2 = {1 , 3};
        assertEquals(2 , longestValidSubsequence.maximumLength(nums2));
    }
}
