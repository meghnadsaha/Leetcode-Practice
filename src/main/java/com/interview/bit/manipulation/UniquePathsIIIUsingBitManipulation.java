package com.interview.bit.manipulation;

/**
 * Using bit manipulation to optimize the backtracking solution further.
 * By representing the visited squares as a bitmask, you can reduce the space complexity and improve the performance.
 * <p>
 * In this solution, the bitmask is represented using an integer mask, where each bit corresponds to a square on the grid. If a bit is set to 1, it indicates that the corresponding square has been visited. The operations mask |= currentBit and mask &= ~currentBit are used to set and unset the bits respectively.
 * <p>
 * Using bit manipulation reduces the space complexity compared to storing the visited squares in a separate memoization array. It also allows for efficient checking of whether a square has been visited using bitwise operations.
 * <p>
 * This optimized solution with bit manipulation further improves the performance and reduces memory usage compared to the basic backtracking solution.
 *
 * In the optimized solution using bit manipulation, the time and space complexity can be analyzed as follows:
 *
 *
 * Time Complexity: The time complexity of the solution remains the same as the basic backtracking solution, which is
 * O(4^E), where E is the number of empty squares. The number of possible paths still grows exponentially with the number of empty squares. Therefore, the time complexity is not improved by using bit manipulation.
 *
 * Space Complexity: The space complexity is reduced compared to the basic backtracking solution. Instead of using a memoization array, we store the visited squares as a bitmask in the mask variable. The space required to store the bitmask is O(1) since it is represented using an integer. Thus, the space complexity is constant,
 * O(1).
 *
 * It's important to note that the space complexity analysis assumes the input grid and additional variables used for bookkeeping are not included. The O(1) space complexity refers specifically to the space required by the bit manipulation technique itself, excluding any other space used by the input or variables.
 *
 * In summary, using bit manipulation in the optimized solution reduces the space complexity to O(1) compared to the memoization approach. However, the time complexity remains the same as the basic backtracking solution, which is exponential.
 */
public class UniquePathsIIIUsingBitManipulation {

    private int[][] grid;
    private int rowCount;
    private int colCount;
    private int emptyCount;
    private int count;
    private int startX;
    private int startY;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        this.emptyCount = 0;
        this.count = 0;

        int startMask = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    emptyCount++;
                }
            }
        }

        backtrack(startX, startY, startMask, emptyCount + 1);
        return count;
    }

    private void backtrack(int x, int y, int mask, int remaining) {
        if (grid[x][y] == 2 && remaining == 0) {
            count++; // Reached the ending position and visited all empty squares
            return;
        }

        int currentBit = (1 << (x * colCount + y));
        mask |= currentBit; // Mark the current square as visited

        int[] dx = {0, 0, -1, 1}; // direction arrays for four directions: up, down, left, right
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isValid(newX, newY) && grid[newX][newY] != -1 && ((mask >> (newX * colCount + newY)) & 1) == 0) {
                backtrack(newX, newY, mask, remaining - 1);
            }
        }

        mask &= ~currentBit; // Unmark the current square

    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < rowCount && y >= 0 && y < colCount;
    }
}
