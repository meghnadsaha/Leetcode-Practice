package com.interview.random.google;

public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {

        int result = 0, cell_val = 0;
        if (matrix.length == 0)
            return 0;
        for (int r = 0; r < matrix.length; r++)
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[r][c] == 1)
                    if (r > 0 && c > 0)
                        matrix[r][c] = Math.min(Math.min(matrix[r - 1][c], matrix[r][c - 1]), matrix[r - 1][c - 1]) + 1;
                result += matrix[r][c];
            }

        return result;

    }
}