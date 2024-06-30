package com.interview.contest.weeklycontest.c_404;

public class LongestValidSubsequence_100357 {

//https://leetcode.com/contest/weekly-contest-404/problems/find-the-maximum-length-of-valid-subsequence-i/description/
    public static int maximumLength(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums.length; // Return length of the array if there are fewer than 2 elements
        }

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] + nums[i - 1]) % 2 == 1) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        maxLength = Math.max(maxLength, currentLength);

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(maximumLength(nums1));  // Output: 4

        int[] nums2 = {1, 2, 1, 1, 2, 1, 2};
        System.out.println(maximumLength(nums2));  // Output: 6

        int[] nums3 = {1, 3};
        System.out.println(maximumLength(nums3));  // Output: 2
    }
}
