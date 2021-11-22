package com.interview.dynamic.programming.medium;

import java.util.Map;
import java.util.TreeMap;

public class MaximumProductSubarray {
    //https://leetcode.com/problems/maximum-product-subarray/discuss/847520/Thought-process-and-useful-strategy
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            throw new IllegalArgumentException();
        }

        int[] maxVal = new int[n];
        int[] minVal = new int[n];

        maxVal[0] = nums[0];
        minVal[0] = nums[0];

        for (int i = 1; i < n; i++) {
            maxVal[i] = Math.max(maxVal[i - 1] * nums[i], Math.max(minVal[i - 1] * nums[i], nums[i]));
            minVal[i] = Math.min(maxVal[i - 1] * nums[i], Math.min(minVal[i - 1] * nums[i], nums[i]));
        }

        int ans = Integer.MIN_VALUE;
        for (int num : maxVal) {
            ans = Math.max(ans, num);
        }
        return ans;
    }


}