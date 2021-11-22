package com.interview.dynamic.programming.medium;

public class MinimumPathSum {

    //https://leetcode.com/problems/unique-paths-ii/discuss/1513891/Java-or-TC:-O(R*C)-or-SC:-O(min(RC))-or-Space-optimized-Dynamic-Programming-solution

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            throw new IllegalArgumentException("Input grid is null");
        }
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        if (rows == 1 && cols == 1) {
            return grid[0][0];
        }

        if (cols <= rows) {
            return minPathSumHelper(grid, rows, cols, true);
        } else {
            return minPathSumHelper(grid, cols, rows, false);
        }
    }

    private int minPathSumHelper(int[][] grid, int big, int small, boolean isColsSmall) {
        int[] dp = new int[small];
        // Process 1st small column/row
        dp[0] = grid[0][0];
        for (int j = 1; j < small; j++) {
            dp[j] = dp[j - 1] + (isColsSmall ? grid[0][j] : grid[j][0]);
        }
        // Process remaining columns/rows
        for (int i = 1; i < big; i++) {
            dp[0] += isColsSmall ? grid[i][0] : grid[0][i];
            for (int j = 1; j < small; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + (isColsSmall ? grid[i][j] : grid[j][i]);
            }
        }
        return dp[small - 1];
    }

    // Dp Based Solution

//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        //Initialisation
//        int[][] dp = new int[m][n];
//
//        //Base Case Transformation
//
//        dp[0][0] = grid[0][0];
//        for (int i = 1; i < n; i++) {
//            dp[0][i] = dp[0][i - 1] + grid[0][i];
//        }
//
//        for (int i = 1; i < m; i++) {
//            dp[i][0] = dp[i - 1][0] + grid[i][0];
//        }
//
//        //Main logic
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

}