package com.interview.graph.dfs.medium;

public class NumberofIslandsDFS {
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int max = 0;

        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (vis[i][j] == 0)
                        max++;

                    dfs(i, j, grid, vis);

                }
            }
        }
        return max;
    }

    private void dfs(int i, int j, char[][] grid, int[][] vis) {

        if (vis[i][j] == 1)
            return;

        vis[i][j] = 1;

        if (i - 1 >= 0 && grid[i - 1][j] == '1')
            dfs(i - 1, j, grid, vis);

        if (j - 1 >= 0 && grid[i][j - 1] == '1')
            dfs(i, j - 1, grid, vis);

        if (j + 1 <= grid[0].length - 1 && grid[i][j + 1] == '1')
            dfs(i, j + 1, grid, vis);

        if (i + 1 <= grid.length - 1 && grid[i + 1][j] == '1')
            dfs(i + 1, j, grid, vis);

    }
}
