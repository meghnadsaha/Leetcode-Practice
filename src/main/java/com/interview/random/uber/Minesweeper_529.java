package com.interview.random.uber;

public class Minesweeper_529 {

    /**
     * If click on a mine ('M'), mark it as 'X', stop further search.
     * If click on an empty cell ('E'), depends on how many surrounding mine:
     * 2.1 Has surrounding mine(s), mark it with number of surrounding mine(s), stop further search.
     * 2.2 No surrounding mine, mark it as 'B', continue search its 8 neighbors.
     */

    public static char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];


        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= m || c < 0 || c >= n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                }
            }


            if (count > 0) {
                board[row][col] = (char) (count + '0');
            } else {
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c >= n) continue;
                        if (board[r][c] == 'E') updateBoard(board, new int[]{r, c});
                    }
                }
            }
        }
        return board;

    }

    public static void main(String[] args) {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};

        char[][] output = updateBoard(board, click);


        char[][] board2 = {
                {'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        };
        int[] click2 = {1, 2};

        char[][] output2 =  updateBoard(board2, click2);
    }
}