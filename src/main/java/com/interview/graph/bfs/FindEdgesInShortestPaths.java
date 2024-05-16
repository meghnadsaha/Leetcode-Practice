package com.interview.graph.bfs;

public class FindEdgesInShortestPaths {
    public double findMaxAverage ( int[] nums , int k ) {

        int n = nums.length;
        double sum = 0;
        double max_sum = Double.NEGATIVE_INFINITY;

        for (int i = 0 ; i < k ; i++) {
            sum += nums[i];
        }
        max_sum = Math.max(max_sum , sum);

        for (int i = k ; i < n ; i++) {
            sum = sum - nums[i - k] + nums[i];
            max_sum = Math.max(max_sum , sum);
        }
        return max_sum / k;
    }

    public static void main ( String[] args ) {
        
    }
}
