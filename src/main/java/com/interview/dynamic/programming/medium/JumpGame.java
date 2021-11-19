package com.interview.dynamic.programming.medium;

public class JumpGame {


    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = goal; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0 ? true:false;
    }

//    public boolean canJump(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        dp[0] = nums[0];
//        if (n == 1) return true;
//        for (int i = 1; i < n - 1; i++) {
//            if (dp[i - 1] < i) return false;
//
//            dp[i] = Math.max(dp[i - 1], nums[i] + i);
//
//            if (dp[i] >= n - 1) return true;
//        }
//        return dp[n - 2] >= n - 1 ? true : false;
//    }

}
