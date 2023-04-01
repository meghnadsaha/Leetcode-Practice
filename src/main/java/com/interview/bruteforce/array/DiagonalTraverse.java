package com.interview.bruteforce.array;

import java.util.ArrayList;
import java.util.Collections;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int N = matrix.length;
        int M = matrix[0].length;

        int[] result = new int[N * M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<>();

        for (int i = 0; i < N + M - 1; i++) {
            intermediate.clear();

            int row = i < M ? 0 : i - M + 1;
            int column = i < M ? i : M - 1;

            while (row < N && column > -1) {
                System.out.println("matrix["+row+"]["+column+"] : "+matrix[row][column]);
                intermediate.add(matrix[row][column]);
                ++row;
                --column;
            }
            if (i % 2 == 0) {
                Collections.reverse(intermediate);
            }
            for (int j = 0; j < intermediate.size(); j++) {
                result[k++] = intermediate.get(j);
            }
        }
        return result;
    }
}