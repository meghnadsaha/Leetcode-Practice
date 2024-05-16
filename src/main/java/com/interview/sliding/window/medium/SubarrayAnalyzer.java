package com.interview.sliding.window.medium;

//https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

import java.lang.reflect.Array;
import java.util.Arrays;

public class SubarrayAnalyzer {
    public static int numOfSubarrays ( int[] arr , int k , int threshold ) {
        int count = 0;
        int sum = 0;
        int target = k * threshold;//Calculates the target sum required for the average of the subarray to be greater than or equal to threshold.

        for (int i = 0 ; i < arr.length ; i++) {
            sum += arr[i];

            if (i >= k - 1) { //Checks if the window size has reached k
                if (i >= k) {//: Checks if the window size has exceeded k
                    sum -= arr[i - k];//Removes the element outside the current window from the sum.
                }

                if (sum >= target) {
                    count++;

                    int[] subarray = new int[k];
                    System.arraycopy(arr , i - k + 1 , subarray , 0 , k);
                    System.out.println(Arrays.toString(subarray));

                }
            }
        }

        return count;
    }

    public static void main ( String[] args ) {
        int[] arr = {2 , 2 , 2 , 2 , 5 , 5 , 5 , 8};
        int k = 3, threshold = 4;
        int result = numOfSubarrays(arr , k , threshold);
    }
}
