package com.interview.tree.dfs.medium;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfIslandsTest {
    @Test
    public void testNumIslands() {
        NumberOfIslands numberOfIslands = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int actualOutput = numberOfIslands.numIslands(grid);

        Assert.assertEquals(1, actualOutput);
    }

    @Test
    public void testNumIslands2() {
        NumberOfIslands numberOfIslands = new NumberOfIslands();

        char[][] grid =
                {
                        {'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}
                };
        int actualOutput = numberOfIslands.numIslands(grid);

        Assert.assertEquals(3, actualOutput);
    }
}
