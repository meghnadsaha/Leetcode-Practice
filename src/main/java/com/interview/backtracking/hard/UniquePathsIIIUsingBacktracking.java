package com.interview.backtracking.hard;

/**
 * The code uses backtracking to explore all possible paths from the starting square to the ending square while keeping track of the visited squares and the number of empty squares remaining.
 * <p>
 * If the current square is the ending square and all empty squares have been visited, the count is incremented.
 * <p>
 * <p>
 * In the backtracking solution without memoization, the time and space complexity can be analyzed as follows:
 * <p>
 * Time Complexity: The time complexity of the backtracking algorithm depends on the number of possible paths from the starting square to the ending square. In the worst case, where there are no obstacles, the algorithm explores all possible paths. For each empty square, there are 4 possible directions to move (up, down, left, right), and we need to visit each empty square exactly once. Therefore, the time complexity is
 * O(4^E), where E is the number of empty squares.
 * <p>
 * Space Complexity: The space complexity of the backtracking algorithm depends on the recursion depth, which is determined by the maximum number of steps to reach the ending square. In the worst case, where there are no obstacles, the maximum number of steps is equal to the number of cells in the grid (m * n). Therefore, the space complexity is
 * O(m * n) for the recursion stack.
 * <p>
 * It's important to note that these time and space complexities are worst-case analyses assuming the absence of obstacles. The actual time and space complexity may be lower in practice depending on the specific characteristics of the grid and the distribution of obstacles.
 */
public class UniquePathsIIIUsingBacktracking {

    private int[][] grid;
    private int rowCount;
    private int colCount;
    private int[] dx = {0, 0, -1, 1}; // direction arrays for four directions: up, down, left, right
    private int[] dy = {-1, 1, 0, 0};
    private int count;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        this.count = 0;

        int startX = -1;
        int startY = -1;
        int emptyCount = 0;

        // Find the starting position and count the number of empty squares
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

        // Perform backtracking starting from the starting position
        backtrack(startX, startY, emptyCount + 1);

        return count;
    }

    private void backtrack(int x, int y, int remaining) {
        if (grid[x][y] == 2 && remaining == 0) {
            count++; // Reached the ending position and visited all empty squares
            return;
        }

        int temp = grid[x][y]; // Store the original value
        grid[x][y] = -1; // Mark the current square as visited

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (isValid(newX, newY)) {
                backtrack(newX, newY, remaining - 1);
            }
        }

        grid[x][y] = temp; // Restore the original value
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < rowCount && y >= 0 && y < colCount && grid[x][y] != -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        int[][] grid2 = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        };

        UniquePathsIIIUsingBacktracking solution = new UniquePathsIIIUsingBacktracking();
        int numPaths = solution.uniquePathsIII(grid2);
        System.out.println("Number of unique paths: " + numPaths);
    }
}
