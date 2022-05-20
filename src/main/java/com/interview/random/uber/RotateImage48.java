package com.interview.random.uber;

public class RotateImage48 {
//    The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
//
//        1  2  3
//        4  5  6
//        7  8  9
//    after transpose, it will be swap(matrix[i][j], matrix[j][i])
//
//        1  4  7
//        2  5  8
//        3  6  9
//    Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
//
//        7  4  1
//        8  5  2
//        9  6  3.

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}