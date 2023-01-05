package com.interview.graph.bfs.medium;

import java.util.*;


/**
 * The DFS solution is straightforward. Starting from each point, and dfs its neighbor
 * if the neighbor is equal or less than itself. And maintain two boolean matrix for two oceans,
 * indicating an ocean can reach to that point or not. Finally go through all nodes again and see
 * if it can be both reached by two oceans. The trick is if a node is already visited, no need to
 * visited again. Otherwise it will reach the recursion limits.
 *
 *            index  dir  x  y
 *             0  e    1  0
 *             1  se   1  1
 *             2  n    0  1
 *             3  nw  -1  1
 *             4  w   -1  0
 *             5  sw  -1 -1
 *             6  s    0 -1
 *             7  ne   1 -1
 */
public class PacificAtlanticWaterFlowBFS {


    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) { //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m - 1});
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        for (int i = 0; i < m; i++) { //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n - 1, i});
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    public static void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited) {
        int n = matrix.length, m = matrix[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]) {
                    continue;
                }
                visited[x][y] = true;
                print2D(visited);
                queue.offer(new int[]{x, y});
            }
        }
    }

    public static void print2D(boolean[][] mat) {
        for (boolean[] row : mat)
            System.out.println(Arrays.toString(row));

        System.out.print("\n");
    }


    public static void main(String args[]) {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        System.out.print(pacificAtlantic(heights));
    }
}