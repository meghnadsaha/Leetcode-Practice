package com.interview.dynamic.programming.medium;

public class MaximalSquare {
    /**
     * Space optimized Dynamic Programming solution
     *
     * DP[i][j] = Maximal size (square = size*size) of the square that can be formed ending at point (i,j).
     *
     * Time Complexity: O(M * N)
     *
     * Space Complexity: O(min(M, N))
     *
     * M = Number of rows. N = Number of columns.
     */
        public int maximalSquare(char[][] matrix) {
            if (matrix == null) {
                throw new IllegalArgumentException("Input is null");
            }
            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;

            if (rows < cols) {
                return maximalSquareHelper(matrix, cols, rows, false);
            } else {
                return maximalSquareHelper(matrix, rows, cols, true);
            }
        }

        private int maximalSquareHelper(char[][] matrix, int big, int small, boolean isColsSmall) {
            int[] dp = new int[small + 1];
            int maxSide = 0;
            for (int j = 1; j <= big; j++) {
                int prev = dp[0]; // Since we have added a padding in-front, dp[0] will always be zero
                for (int i = 1; i <= small; i++) {
                    int temp = dp[i];
                    if ((isColsSmall && matrix[j - 1][i - 1] == '0') || (!isColsSmall && matrix[i - 1][j - 1] == '0')) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(prev, Math.min(dp[i], dp[i - 1])) + 1;
                        maxSide = Math.max(maxSide, dp[i]);
                    }
                    prev = temp;
                }
            }
            return maxSide * maxSide;
        }
    }