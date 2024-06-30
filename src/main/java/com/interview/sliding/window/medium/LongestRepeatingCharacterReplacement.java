package com.interview.sliding.window.medium;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement ( String s , int k ) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;
        int startOfReplacement = 0; // Start index of the substring that needs to be replaced

        for (int right = 0 ; right < s.length() ; right++) {
            maxCount = Math.max(maxCount , ++count[s.charAt(right) - 'A']);
            System.out.println("Count array Before shrinking\n"+Arrays.toString(count));

            // If the window size minus the maximum count is greater than k, shrink the window from the left
            if (right - left + 1 - maxCount > k) {
                extracted(s , left , right,"Before shrinking:");
                count[s.charAt(left++) - 'A']--;
                extracted(s , left , right,"After  shrinking:");
                System.out.println("Count array  After shrinking\n"+Arrays.toString(count)+ "\n");
            }


            maxLength = Math.max(maxLength , right - left + 1);
            System.out.println("maxLength :"+maxLength);

        }

//        extracted(s , maxLength , startOfReplacement);

        return maxLength;
    }

    private static void extracted ( String s , int maxLength , int startOfReplacement ) {
        // Build the replaced string
        StringBuilder replacedString = new StringBuilder(s);
        for (int i = startOfReplacement ; i < startOfReplacement + maxLength ; i++) {
            replacedString.setCharAt(i , s.charAt(startOfReplacement));
            System.out.println("Replaced string after replacement: " + replacedString.toString());

        }
    }

    private static void extracted ( String s , int left , int right ,String msg) {
        // Print the window and the changed string before shrinking
        System.out.print(msg);
        for (int i = left ; i <= right ; i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
    }


    public static void main ( String[] args ) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
        String s = "ABAB";
        int k = 2;
//        System.out.println(solution.characterReplacement(s , k));  // Output: 4

        s = "AABABBA";
        k = 1;
        System.out.println(solution.characterReplacement(s , k));  // Output: 4
    }
}

