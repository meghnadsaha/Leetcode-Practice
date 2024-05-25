package com.interview.contest.biweeklycontest131;


import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/contest/biweekly-contest-131/problems/find-occurrences-of-an-element-in-an-array/

public class FindOccurrences {
    public static int[] findOccurrences ( int[] nums , int[] queries , int x ) {
        List<Integer> occurrences = new ArrayList<>();

        // Find all the occurrences of x in nums and store their indices
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] == x) {
                occurrences.add(i);
            }
        }

        int[] answer = new int[queries.length];

        // Process each query
        for (int i = 0 ; i < queries.length ; i++) {
            int query = queries[i];
            // Check if the queryth occurrence exists
            if (query <= occurrences.size()) {
                answer[i] = occurrences.get(query - 1);
            } else {
                answer[i] = -1;
            }
        }

        return answer;
    }

    public static void main ( String[] args ) {
        int[] nums1 = {1 , 3 , 1 , 7};
        int[] queries1 = {1 , 3 , 2 , 4};
        int x1 = 1;
        int[] result1 = findOccurrences(nums1 , queries1 , x1);
        // Output: [0, -1, 2, -1]
        for (int res : result1) {
            System.out.print(res + " ");
        }
        System.out.println();

        int[] nums2 = {1 , 2 , 3};
        int[] queries2 = {10};
        int x2 = 5;
        int[] result2 = findOccurrences(nums2 , queries2 , x2);
        // Output: [-1]
        for (int res : result2) {
            System.out.print(res + " ");
        }
    }
}
