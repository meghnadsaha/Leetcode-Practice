package com.interview.sliding.window.easy;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {

    public static String longestNiceSubstring ( String s ) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        String result = "";

        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = i + maxLength + 1 ; j <= s.length() ; j++) {
                String sub = s.substring(i , j);
                System.out.println("Window: [" + i + ", " + (j - 1) + "]");
                System.out.println("Current substring: " + sub);
                if (isNice(sub)) {
                    if (sub.length() > maxLength) {
                        maxLength = sub.length();
                        result = sub;
                    }
                }
            }
        }

        return result;
    }

    //    private static boolean isNice(String sub) {
//        for (char c = 'a'; c <= 'z'; c++) {
//            char upper = Character.toUpperCase(c);
//            char lower = Character.toLowerCase(c);
//            if ((sub.indexOf(upper) != -1 && sub.indexOf(lower) == -1) ||
//                    (sub.indexOf(upper) == -1 && sub.indexOf(lower) != -1)) {
//                return false;
//            }
//        }
//        return true;
//    }
    private static boolean isNice ( String sub ) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char c : sub.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = true;
            } else {
                upper[c - 'A'] = true;
            }
        }
        for (int i = 0 ; i < 26 ; i++) {
            if (lower[i] != upper[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main ( String[] args ) {
        String s = "YazaAay";
        System.out.println("Longest nice substring: " + longestNiceSubstring(s)); // Output: "aAa"

    }
}
