package com.interview.dynamic.programming.medium;

import java.util.Arrays;

public class MinimumNumberOfOperationsToSatisfyConditions {

    public int minimumOperations ( int[][] grid ) {

        int m = grid.length;
        int n = grid[0].length;
        int[][] cnt = new int[n][10]; // Count of each number in each column
        int[][] memo = new int[n][11]; // Memoization array

        for (int j = 0 ; j < n ; j++) {
            Arrays.fill(cnt[j] , 0);
            Arrays.fill(memo[j] , -1);
        }

        // Count numbers in each column
        for (int j = 0 ; j < n ; j++) {
            for (int i = 0 ; i < m ; i++) {
                cnt[j][grid[i][j]]++;
            }
        }

        return m * n - dp(0 , -1 , cnt , memo);
    }

    private int dp ( int i , int p , int[][] cnt , int[][] memo ) {
        if (i == cnt.length) return 0;
        if (memo[i][p + 1] != -1) return memo[i][p + 1];

        int res = 0;
        for (int v = 0 ; v < 10 ; v++) {
            if (v != p) {
                res = Math.max(res , cnt[i][v] + dp(i + 1 , v , cnt , memo));
            }
        }

        memo[i][p + 1] = res;
        return res;
    }


    public static void main ( String[] args ) {
        MinimumNumberOfOperationsToSatisfyConditions solution = new MinimumNumberOfOperationsToSatisfyConditions();

        // Test cases
        int[][] grid1 = {{1 , 0 , 2} , {1 , 0 , 2}};
        System.out.println(solution.minimumOperations(grid1)); // Output: 0

        int[][] grid2 = {{1 , 1 , 1} , {0 , 0 , 0}};
        System.out.println(solution.minimumOperations(grid2)); // Output: 3

        int[][] grid3 = {{1} , {2} , {3}};
        System.out.println(solution.minimumOperations(grid3)); // Output: 2

        int[][] grid4 = {{1 , 1 , 1} , {1 , 1 , 1}};
        System.out.println(solution.minimumOperations(grid4)); // Output: 3

        int[][] grid5 = {{1 , 1 , 1 , 1} , {0 , 0 , 0 , 0}};
        System.out.println(solution.minimumOperations(grid5)); // Output: 5
    }
}

