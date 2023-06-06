package com.interview.graph.dfs.medium;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int ans = 0;

        int row = grid.length;
        int col = grid[0].length;
        // Check if the start or end cell is blocked
        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        int[][] directions = {
                {-1, 0},   // Up            :Represents moving upwards by decreasing the row index (Up).
                {1, 0},    // Down          :Represents moving downwards by increasing the row index (Down).
                {0, -1},   // Left          :Represents moving towards the left by decreasing the column index (Left).
                {0, 1},    // Right         :Represents moving towards the right by increasing the column index (Right).
                {-1, -1},  // Up-Left       :Represents moving diagonally towards the top-left by decreasing both the row and column indices (Up-Left).
                {-1, 1},   // Up-Right      :Represents moving diagonally towards the top-right by decreasing the row index and increasing the column index (Up-Right).
                {1, -1},   // Down-Left     :Represents moving diagonally towards the bottom-left by increasing the row index and decreasing the column index (Down-Left).
                {1, 1}     // Down-Right    :Represents moving diagonally towards the bottom-right by increasing both the row and column indices (Down-Right).
        };

        //1. Initialize a queue to perform BFS traversal and a visited set to keep track of visited cells.
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        //2. Add the starting cell (0, 0) to the queue and mark it as visited.
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        //3. Initialize a variable to keep track of the length of the path and set it to 1.
        int pathLength = 1;

        while (!queue.isEmpty()) {
            //4. Get the current cell from the front of the queue.
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                //5. Check if the current cell is the destination (i.e., (ROW - 1, COL - 1)).
                // If it is, return the length of the path.
                if (x == row - 1 && y == col - 1) {
                    return pathLength;
                }
                //6. Explore all eight adjacent cells of the current cell.
                Arrays.stream(directions).forEachOrdered(dir -> {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 0 && !visited[nx][ny]) {
                        //7. If the adjacent cell is valid (inside the grid boundaries) and
                        // has a value of 0 (clear path) and has not been visited before, mark it as visited,
                        visited[nx][ny] = true;

                        //8. add it to the queue.
                        queue.offer(new int[]{nx, ny});
                    }
                });
            }
            // And increment the path length by 1.
            pathLength++;
        }
        //If the destination cell is not reached, return -1 (clear path does not exist).
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
