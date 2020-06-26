package com.interview.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (helper(board, i, j, word, 0, new boolean[m][n])) return true;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, int row, int col,
        String word, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (row < 0 || col < 0 || row >= board.length ||
            col >= board[0].length) return false;
        if (visited[row][col]) return false;
        if (board[row][col] != word.charAt(index)) return false;

        visited[row][col] = true;
        if (helper(board, row + 1, col, word, index + 1, visited) ||
            helper(board, row - 1, col, word, index + 1, visited) ||
            helper(board, row, col - 1, word, index + 1, visited) ||
            helper(board, row, col + 1, word, index + 1, visited)) return true;

        visited[row][col] = false;
        return false;
    }
}