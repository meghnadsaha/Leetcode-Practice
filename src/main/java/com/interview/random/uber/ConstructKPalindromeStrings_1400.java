package com.interview.random.uber;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings_1400 {


    public static boolean canConstruct(String s, int k) {

        if (s.length() == k)
            return true;

        int oddFrequency = 0;
        int n = s.length();
        int[] counts = new int[26];

        for (int i=0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            oddFrequency += counts[s.charAt(i) - 'a'] % 2 == 0 ? -1 : 1;
        }

        return oddFrequency < k && k <= s.length();
    }

    public static void main(String[] args) {
        String S = "leetcode";
        int K = 3;

        if (canConstruct(S, K))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}