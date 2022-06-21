package com.interview.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MinimumWindowSubstring {
    /**
     * Example 1:
     * <p>
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The smallest substring of s that includes all the characters of t is "BANC".
     * Example 2:
     * <p>
     * Input: s = "a", t = "a"
     * Output: "a"t
     * Example 3:
     * <p>
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the smallest substring. Since no such substring exists, return "".
     **/
    private static String findMinimumWindowSubstring(String s, String t) {
        int n = s.length();

        // length of the minimum window substring (smallest substring of s that has all characters of t)
        int minWindowSubstrLength = Integer.MAX_VALUE;

        // start index of the minimum window substring
        int minWindowSubstrStart = 0;

        // stores the count of each character in the current window
        Map<Character, Integer> windowCharMap = new HashMap<>();

        // stores the count of each character in the string t
        Map<Character, Integer> substrMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            substrMap.put(c, substrMap.getOrDefault(c, 0) + 1);
        }

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            // Add the next character of the string to the window
            char c = s.charAt(windowEnd);
            windowCharMap.put(c, windowCharMap.getOrDefault(c, 0) + 1);

            // Keep looking for a smaller window while the current window substring contains all the characters of t
            while (containsAll(windowCharMap, substrMap)) {
                if (windowEnd - windowStart + 1 < minWindowSubstrLength) {
                    minWindowSubstrLength = windowEnd - windowStart + 1;
                    minWindowSubstrStart = windowStart;
                }

                // move the leftmost character out of the window
                char leftChar = s.charAt(windowStart);
                windowCharMap.put(leftChar, windowCharMap.get(leftChar) - 1);
                if (windowCharMap.get(leftChar) == 0) {
                    windowCharMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
        }

        return s.substring(minWindowSubstrStart, minWindowSubstrStart + minWindowSubstrLength);
    }

    private static boolean containsAll(Map<Character, Integer> windowCharMap, Map<Character, Integer> substrMap) {
        for (Map.Entry<Character, Integer> entry : substrMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if (!windowCharMap.containsKey(c)) {
                return false;
            }

            if (windowCharMap.get(c) < count) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String s = "ADOBECODEBANC";
        String t = "ABC";

        keyboard.close();

        System.out.printf("Minimum window substring = %s%n", findMinimumWindowSubstring(s, t));
    }
}