package com.interview.dynamic.programming.medium;

public class PalindromicSubstring {

    public int countSubstrings(String s) {
        int n = s.length();
        if (n < 2)
            return n;
        int count = n;
        boolean[][] dp = new boolean[n][n];
        // size 1 substrings are palindromes
        for (int i = 0; i < n; i++)
            dp[i][i] = true;
        // for size 2 substrings, check first and last char
        for (int i = 0; i + 1 < n; i++)
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        // for size = 3+
        for (int len = 2; len < n; len++) // controls the size of the substring
            for (int i = 0; i + len < n; i++) { // controls the start index
                int j = i + len; // end index
                if ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count++;
                }
            }
        return count;
    }


}
