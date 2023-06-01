package com.interview.graph.dfs.medium;


import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Cell {
    public int getDistance() {
        return distance;
    }

    int row;
    int col;
    int distance;

    public Cell(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class ShortestPathInBinaryMatrixUsingAStar {
    public static int shortestPath(int[][] grid) {
        int n = grid.length;

        // Check if the start or end cell is blocked
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        // A* search algorithm
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        // Priority queue for open cells
        PriorityQueue<Cell> queue = new PriorityQueue<>(Comparator.comparing(Cell::getDistance));
        queue.offer(new Cell(0, 0, 0));
        distance[0][0] = 0;

        // Set for closed cells
        Set<Cell> closed = new HashSet<>();

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            // Check if the current cell is the destination
            if (current.row == n - 1 && current.col == n - 1) {
                return current.distance + 1;
            }

            closed.add(current);

            // Explore neighboring cells
            for (int[] dir : directions) {
                int newRow = current.row + dir[0];
                int newCol = current.col + dir[1];

                // Check if the neighboring cell is within the grid bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                    // Check if the neighboring cell is a clear path
                    if (grid[newRow][newCol] == 0) {
                        int newDistance = current.distance + 1;

                        // Update the distance if it's shorter than the current distance
                        if (newDistance < distance[newRow][newCol]) {
                            Cell neighbor = new Cell(newRow, newCol, newDistance);
                            if (closed.contains(neighbor)) {
                                closed.remove(neighbor);
                            }
                            queue.offer(neighbor);
                            distance[newRow][newCol] = newDistance;
                        }
                    }
                }
            }
        }

        return -1; // No clear path found
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        int[][] grid2 = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPath(grid2));
    }
}
