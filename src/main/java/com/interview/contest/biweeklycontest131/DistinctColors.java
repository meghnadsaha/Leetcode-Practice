package com.interview.contest.biweeklycontest131;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/contest/biweekly-contest-131/problems/find-the-number-of-distinct-colors-among-the-balls/description/
public class DistinctColors {
    /**
     * Sure, let's break down the example `Input: limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]` step by step to explain how we get the output `[1, 2, 2, 3]`.
     * <p>
     * ### Initial State
     * - We have 5 balls labeled from 0 to 4 (since `limit = 4`).
     * - Initially, all balls are uncolored.
     * <p>
     * ### Processing Each Query
     * <p>
     * 1. **Query [1, 4]:**
     * - Ball 1 is colored with color 4.
     * - Current colors: Ball 1 -> 4
     * - Distinct colors: {4}
     * - Number of distinct colors: 1
     * - Result after this query: `[1]`
     * <p>
     * 2. **Query [2, 5]:**
     * - Ball 2 is colored with color 5.
     * - Current colors: Ball 1 -> 4, Ball 2 -> 5
     * - Distinct colors: {4, 5}
     * - Number of distinct colors: 2
     * - Result after this query: `[1, 2]`
     * <p>
     * 3. **Query [1, 3]:**
     * - Ball 1 is re-colored with color 3 (changing from color 4 to color 3).
     * - Current colors: Ball 1 -> 3, Ball 2 -> 5
     * - Distinct colors: {3, 5}
     * - Number of distinct colors: 2
     * - Result after this query: `[1, 2, 2]`
     * <p>
     * 4. **Query [3, 4]:**
     * - Ball 3 is colored with color 4.
     * - Current colors: Ball 1 -> 3, Ball 2 -> 5, Ball 3 -> 4
     * - Distinct colors: {3, 4, 5}
     * - Number of distinct colors: 3
     * - Result after this query: `[1, 2, 2, 3]`
     * <p>
     * ### Summary
     * <p>
     * - After the first query, there is 1 distinct color.
     * - After the second query, there are 2 distinct colors.
     * - After the third query, there are still 2 distinct colors (even though the color of ball 1 changed, it still resulted in the same number of distinct colors).
     * - After the fourth query, there are 3 distinct colors.
     * <p>
     * The result `[1, 2, 2, 3]` represents the number of distinct colors present after each query in the sequence.
     */


    public static int[] queryResults ( int limit , int[][] queries ) {
        // HashMap to keep track of the current color of each ball
        Map<Integer, Integer> ballColorMap = new HashMap<>();
        // HashSet to keep track of the distinct colors
//        Set<Integer> distinctColors = new HashSet<>();
        Map<Integer, Integer> distinctColors = new HashMap<>();

        // Result array to store the number of distinct colors after each query
        int[] result = new int[queries.length];

        for (int i = 0 ; i < queries.length ; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            // Check if the ball already had a color
            if (ballColorMap.containsKey(ball)) {
                // Remove the old color from the set if it exists
//                distinctColors.remove(ballColorMap.get(ball));

                int prevColor = ballColorMap.get(ball);
                if (distinctColors.containsKey(prevColor)) {
                    int count = distinctColors.get(prevColor);
                    if (count == 1) {
                        distinctColors.remove(prevColor);
                    } else {
                        distinctColors.put(prevColor, count - 1);
                    }
                }


            }

            // Update the color of the ball in the map
            ballColorMap.put(ball , color);
            // Add the new color to the set of distinct colors
//            distinctColors.add(color);
            distinctColors.put(color, distinctColors.getOrDefault(color, 0) + 1);

            // Record the number of distinct colors
            result[i] = distinctColors.size();
        }

        return result;
    }



    public static void main ( String[] args ) {
//        int limit1 = 4;
//        int[][] queries1 = {{1 , 4} , {2 , 5} , {1 , 3} , {3 , 4}};
//        int[] result1 = queryResults(limit1 , queries1);
//        // Output: [1, 2, 2, 3]
//        for (int res : result1) {
//            System.out.print(res + " ");
//        }
//        System.out.println();
//
//        int limit2 = 4;
//        int[][] queries2 = {{0 , 1} , {1 , 2} , {2 , 2} , {3 , 4} , {4 , 5}};
//        int[] result2 = queryResults(limit2 , queries2);
//        // Output: [1, 2, 2, 3, 4]
//        for (int res : result2) {
//            System.out.print(res + " ");
//        }


        int limit3 = 1;
        int queries3[][] = {{0 , 1} , {1 , 4} , {1 , 1} , {1 , 4} , {1 , 1}};
        int[] result3 = queryResults(limit3 , queries3);
        for (int res : result3) {
            System.out.print(res + " ");
        }
    }

}
