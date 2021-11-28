package com.interview.dynamic.programming.medium;

public class HouseRobber {
    //https://leetcode.com/problems/house-robber/discuss/1538744/Java-or-0ms-or-100-faster-or-DP-or-Explained
    public int rob(int[] nums) {

        // No houses - can't rob anything
        if(nums == null || nums.length == 0) {
            return 0;
        }

        // single house - can just rob that one house
        if(nums.length == 1) {
            return nums[0];
        }

        // 2 houses - can rob only the max one of them
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 2nd house to the left
        int twoBefore = nums[0];

        // 1st house to the left
        int oneBefore = Math.max(nums[0], nums[1]);

        int curr = 0;

        for(int i=2;i<nums.length;++i) {
            curr = Math.max(twoBefore+nums[i], oneBefore);

            twoBefore = oneBefore;
            oneBefore = curr;

        }

        return curr;

    }
}
