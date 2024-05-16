package com.interview.sliding.window.easy;

import java.util.HashSet;
import java.util.Set;

public class BlockRecoloring {
    //https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description/
    public static int minOperations ( String blocks , int k ) {
        int whiteCount = 0;
        int minOperations = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0 ; right < blocks.length() ; right++) {
            if (blocks.charAt(right) == 'W') {
                whiteCount++;
            }
            // Shrink the window if it exceeds k
            if (right - left + 1 > k) {
                if (blocks.charAt(left) == 'W') {
                    whiteCount--;
                }
                left++;
            }
            if (right - left + 1 == k)
                minOperations = Math.min(minOperations , whiteCount);
                System.out.println(blocks.substring(left, right + 1));

        }

        return minOperations;
    }

    public static void main ( String[] args ) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println(minOperations(blocks , k)); // Output: 3
    }
}
