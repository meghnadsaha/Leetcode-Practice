package com.interview.graph.dfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlowDFS {

    int rows, cols = 0;
    // denotes cells reachable starting from atlantic and pacific edged cells respectively
    int[][] atlantic, pacific;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return ans;
        }
        rows = mat.length;
        cols = mat[0].length;
        pacific = new int[rows][cols];
        atlantic = new int[rows][cols];
        // perform dfs from all edge cells (ocean-connected cells)
        for (int col = 0; col < cols; col++) {
            dfs(0, col, rows, cols, pacific, mat[0][col], mat);
            dfs(rows - 1, col, rows, cols, atlantic, mat[rows - 1][col], mat);
        }
        for (int row = 0; row < rows; row++) {
            dfs(row, 0, rows, cols, pacific, mat[row][0], mat);
            dfs(row, cols - 1, rows, cols, atlantic, mat[row][cols - 1], mat);
        }
        return ans;
    }

    private void dfs(int row, int col, int rows, int cols, int[][] visited, int prevHeight, int[][] heights) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] ==1 || prevHeight > heights[row][col])
            return;
        visited[row][col] = 1;

        print2D(atlantic);
        System.out.println("\n\n");

        // if cell reachable from both the oceans, insert into final answer vector
        if (atlantic[row][col]==1 && pacific[row][col]==1)
            ans.add(Arrays.asList(row, col));
        // dfs from current cell only if height of next cell is greater
        /*⬇️*/
        dfs(row + 1, col, rows, cols, visited, heights[row][col], heights);
        /*⬆️*/
        dfs(row - 1, col, rows, cols, visited, heights[row][col], heights);
        /*➡️*/
        dfs(row, col + 1, rows, cols, visited, heights[row][col], heights);
        /*⬅️*/
        dfs(row, col - 1, rows, cols, visited, heights[row][col], heights);
    }

    public void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}



