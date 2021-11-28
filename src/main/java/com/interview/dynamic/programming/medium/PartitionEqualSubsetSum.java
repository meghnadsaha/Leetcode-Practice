package com.interview.dynamic.programming.medium;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum += i;
        if(sum % 2 != 0) return false; // 2 equal partitions not possible for odd sum
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int  j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) { //empty ss{} sum will be 0
                    dp[i][j] = true;
                } else if(i == 0) { //empty ss{} sum cannot be greater than 0
                    dp[i][j] = false;
                } else if(j == 0 || dp[i - 1][j]) {
                    //j==0 : every array([1], [1,5], [1,5,11], [1,5,11,5]) can have empty ss{}
                    //dp[i-1][j] : without considering current num, check if prev element subset sum is equal to j
                    dp[i][j] = true;
                } else if(j >= nums[i - 1]) { //considering curr. target subset sum must be greater than curr
                    dp[i][j] = dp[i - 1][j - nums[i - 1]]; //remaining,i.e.,target-curr should be fulfilled by prev
                }
            }
        }
        return dp[nums.length][sum];
    }
}
