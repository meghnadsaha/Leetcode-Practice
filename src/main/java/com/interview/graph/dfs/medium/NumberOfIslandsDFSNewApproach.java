package com.interview.graph.dfs.medium;

import com.interview.util.CommonUtil;


public class NumberOfIslandsDFSNewApproach {

    public int numIslands(char[][] grid) {
        int lengthOfTheNows = grid.length;
        int lengthOfTheColumns = grid[0].length;
        int islands = 0;
        for (int i = 0; i < lengthOfTheNows; i++) {
            for (int j = 0; j < lengthOfTheColumns; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    eraseIslands(grid, i, j);
                }
            }
        }
        return islands;
    }

    private void eraseIslands(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        CommonUtil.print2D(grid);
        System.out.print("\n");

        /*⬆️*/
        eraseIslands(grid, i - 1, j);
        /*⬇️*/
        eraseIslands(grid, i + 1, j);
        /*⬅️*/
        eraseIslands(grid, i, j - 1);
        /*➡️*/
        eraseIslands(grid, i, j + 1);
    }
};