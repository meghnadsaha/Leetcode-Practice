package com.interview.util;

import java.util.Arrays;

public class CommonUtil {

    public static void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }

    public static void print2D(boolean mat[][]) {
        for (boolean[] row : mat)
            System.out.println(Arrays.toString(row));
    }

    public static void print2D(char[][] mat) {
        for (char[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
