package com.interview.string;

public class SmallestSubarrayWithAGivenSum {
//    Minimum Size Subarray Sum

    //    https://www.callicoder.com/minimum-size-subarray-sum-smallest-subarray-with-given-sum/
    private static int findLengthOfSmallestSubarray(int[] a, int K) {
        int n = a.length;

        int lengthOfSmallestSubarray = Integer.MAX_VALUE;
        int windowSum = 0;

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += a[windowEnd]; // Add the next element to the window

            while (windowSum > K) { // Shrink the window as small as possible until the 'windowSum' is smaller than or equal to 'K'
                windowSum -= a[windowStart]; // Discard the element at 'windowStart' since it is going out of the window
                windowStart++; // Shrink the window
            }

            if (windowSum == K) {
                lengthOfSmallestSubarray = Math.min(lengthOfSmallestSubarray, windowEnd - windowStart + 1);
            }
        }

        return lengthOfSmallestSubarray == Integer.MAX_VALUE ? 0 : lengthOfSmallestSubarray;
    }

    public static void main(String[] args) {
        int k = 9;
        int[] a = new int[]{3, 4, 1, 1, 2, 1};
        System.out.printf("Length of the Smallest subarray with sum equal to %d = %d%n", k, findLengthOfSmallestSubarray(a, k));

    }

}
