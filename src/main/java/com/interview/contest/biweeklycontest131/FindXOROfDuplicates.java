package com.interview.contest.biweeklycontest131;


import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/contest/biweekly-contest-131/problems/find-the-xor-of-numbers-which-appear-twice/
public class FindXOROfDuplicates {
    public static int findXOROfDuplicates ( int[] nums ) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Count the occurrences of each number
        for (int num : nums) {
            countMap.put(num , countMap.getOrDefault(num , 0) + 1);
        }

        int result = 0;
        // XOR all numbers that appear exactly twice
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 2) {
                result ^= entry.getKey();
            }
        }

        return result;
    }

    public static void main ( String[] args ) {
        int[] nums = {1 , 2 , 1 , 3};
        System.out.println(findXOROfDuplicates(nums)); // Output: 1

        nums = new int[]{1 , 2 , 3};
        System.out.println(findXOROfDuplicates(nums)); // Output: 0

        nums = new int[]{1 , 2 , 2 , 1};
        System.out.println(findXOROfDuplicates(nums)); // Output: 3
    }
}
