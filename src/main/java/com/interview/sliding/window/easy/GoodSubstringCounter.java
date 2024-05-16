package com.interview.sliding.window.easy;

public class GoodSubstringCounter {

    public static int countGoodSubstrings ( String s ) {
        int count = 0;
        for (int i = 0 ; i < s.length() - 2 ; i++) {
            System.out.println("i: " + i + ", i + 3 :" + (i + 3)+" substring: "+s.substring(i , i + 3));
            String substring = s.substring(i , i + 3);
            if (substring.chars().distinct().count() == 3) {
                count++;
            }
        }
        return count;
    }

    private static boolean isGood ( String s ) {
        return s.chars().distinct().count() == 3;
    }

    public static void main ( String[] args ) {
        String s = "xyzzaz";
        System.out.println(countGoodSubstrings(s));  // Output: 1
    }
}
