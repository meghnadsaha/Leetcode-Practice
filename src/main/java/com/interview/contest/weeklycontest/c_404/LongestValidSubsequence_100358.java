package com.interview.contest.weeklycontest.c_404;


import java.util.HashMap;
        import java.util.Map;

public class LongestValidSubsequence_100358 {
//https://leetcode.com/contest/weekly-contest-404/problems/find-the-maximum-length-of-valid-subsequence-ii/description/
    public static int maximumLength(int[] nums, int k)
    {
        int maxLength = 0;
        int currentMod = 0;
        Map<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, -1); // Initialize with remainder 0 at index -1

        for (int i = 0; i < nums.length; i++) {
            currentMod = (currentMod + nums[i]) % k;
            if (currentMod < 0) {
                currentMod += k; // Ensure currentMod is non-negative
            }

            if (remainderCount.containsKey(currentMod)) {
                maxLength = Math.max(maxLength, i - remainderCount.get(currentMod));
            } else {
                remainderCount.put(currentMod, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println(maximumLength(nums1, k1));  // Output: 5

        int[] nums2 = {1, 4, 2, 3, 1, 4};
        int k2 = 3;
        System.out.println(maximumLength(nums2, k2));  // Output: 4
    }
}
