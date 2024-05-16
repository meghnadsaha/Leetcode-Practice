package com.interview.sliding.window;

public class MaximumAverageSubarrayI {
    public static double findMaxAverage ( int[] nums , int k ) {

        int n = nums.length;
        double sum = 0;
        double max_sum = Double.NEGATIVE_INFINITY;

        for (int i = 0 ; i < k ; i++) {
            sum += nums[i];
            System.out.println("nums[" + i + "]: " + nums[i] + " sum: " + sum);

        }
        max_sum = Math.max(max_sum , sum);
        System.out.println("max_sum: " + max_sum);

        for (int i = k ; i < n ; i++) {
            sum = sum - nums[i - k] + nums[i];
            max_sum = Math.max(max_sum , sum);
            System.out.println("n: " + n + " i: " + i + " sum: " + sum + " max_sum: " + max_sum);
        }

        return max_sum / k;
    }

    public static void main ( String[] args ) {
        int[] nums = {1 , 12 , -5 , -6 , 50 , 3};
        int k = 4;
        System.out.println(findMaxAverage(nums , k));
    }
}
