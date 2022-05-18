package com.interview.random.uber;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 },{ 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

//        0 1 2
//        3 4 5 --> 0 can go to {1, 3}
//
//        1 0 2
//        3 4 5 --> 0 can go to index of {0,2,4}
//
//        1 2 0
//        3 4 5 --> 0 can go to {1, 5}
//
//        1 2 3
//        0 4 5 --> 0 can go to {0,4}
//
//        1 2 3
//        4 0 5 --> 0 can go to {1, 3, 5}
//
//        1 2 3
//        4 5 0 --> 0 can go to {2, 4}
public class SlidingPuzzle_773 {
    public static int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();

        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                start.append(ints[j]);
            }
        }

        Set<String> visited = new HashSet<>();
        int[][] dirs = new int[][]{
                {1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}
        };
        Queue<String> queue = new LinkedList<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                assert cur != null;
                if (cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('0');

                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);
                }
            }
            res++;
        }
        return -1;
    }

    private static String swap(String str, int zero, int dir) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(zero, str.charAt(dir));
        sb.setCharAt(dir, str.charAt(zero));
        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] board = {
                {1, 2, 3},
                {4, 0, 5}};


        int output = slidingPuzzle(board);
        System.out.println(output);

    }
}

