package com.interview.dynamic.programming.hard;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence ( String text1 , String text2 ) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1 ; i <= text1.length() ; i++) {
            for (int j = 1 ; j <= text2.length() ; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
                print2D(dp);
                System.out.println("====");

            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void print2D ( int mat[][] ) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }

    public static void main ( String[] args ) {
        System.out.println(longestCommonSubsequence("abcde" , "ace"));
//        System.out.println(longestCommonSubsequence("abc" , "abc"));
//        System.out.println(longestCommonSubsequence("abc" , "def"));

    }
}
