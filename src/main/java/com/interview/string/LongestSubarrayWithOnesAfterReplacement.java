package com.interview.string;

public class LongestSubarrayWithOnesAfterReplacement {
    /**
     * Max Consecutive Ones after replacement
     * <p>
     * Example 1:
     * <p>
     * Input: A = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0], K = 2
     * Output: 6
     * <p>
     * To obtain the longest contiguous subarray of 1s, you can flip the 0s at index 5 and 10 to 1s:
     * [1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1]
     * <p>
     * Example 2:
     * <p>
     * Input: A = [0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
     * Output: 9
     * Explanation: Replace the 0s at index 6, 9, and 10 with 1s to get the longest contiguous subarray of 1s.
     */
    private static int findMaxConsecutiveOnes(int[] a, int k) {
        int maxOnes = Integer.MIN_VALUE;
        int numReplacements = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < a.length; windowEnd++) {
            if (a[windowEnd] == 0) {
                numReplacements++;
            }

            while (numReplacements > k) {
                if (a[windowStart] == 0) {
                    numReplacements--;
                }
                windowStart++;
            }

            maxOnes = Math.max(maxOnes, windowEnd - windowStart + 1);
        }

        return maxOnes;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int result = findMaxConsecutiveOnes(a, k);
        System.out.printf("Length of longest contiguous subarray containing only 1s after replacement = %d%n", result);
    }
}
