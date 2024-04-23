package com.interview.dynamic.programming.hard;

import java.util.Arrays;

public class LongestIncreasingSubsequence {


    public static int lengthOfLIS ( int[] nums ) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp , 1);
        int maxLen = 1;

        for (int i = 1 ; i < nums.length ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen , dp[i]);
        }
        return maxLen;
    }



    public static void main ( String[] args ) {
        System.out.println(lengthOfLIS(new int[]{10 , 9 , 2 , 5 , 3 , 7 , 101 , 18}));
    }
}
