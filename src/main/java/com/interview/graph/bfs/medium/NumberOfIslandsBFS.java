package com.interview.graph.bfs.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Link : https://leetcode.com/problems/number-of-islands/solutions/56589/c-bfs-dfs/?orderBy=most_votes&topicTags=depth-first-search
 */


public class NumberOfIslandsBFS {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0, offsets[] = {0, 1, 0, -1, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    grid[i][j] = '0';

                    Queue<int[]> todoQueue = new LinkedList<>();
                    todoQueue.add(new int[]{i, j});
                    while (!todoQueue.isEmpty()) {
                        int[] curr = todoQueue.poll();
                        for (int k = 0; k < 4; k++) {
                            int r = curr[0] + offsets[k], c = curr[1] + offsets[k + 1];
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                todoQueue.add(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
};