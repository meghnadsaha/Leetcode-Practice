package com.interview.sorting.medium;

import java.util.Arrays;

public class LongestConsecutiveSequenceUsingSorting {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int longStreak = 1;
        int currStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currStreak++;
                } else {
                    longStreak = Math.max(longStreak, currStreak);
                    currStreak = 1;
                }
            }
        }
        return Math.max(longStreak, currStreak);
    }
}
