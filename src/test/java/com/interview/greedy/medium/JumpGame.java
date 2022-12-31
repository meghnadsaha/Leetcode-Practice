package com.interview.greedy.medium;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int limit = 0;
        for (int i = 0; i <= limit; i++) {
            limit = Math.max(limit, i + nums[i]);
            if (limit >= nums.length - 1)
                return true;
        }
        return false;
    }
}