package com.interview.graph.dfs.medium;

import org.junit.Assert;
import org.junit.Test;

public class NumberOfIslandsDFSNewApproachTest {
    protected NumberOfIslandsDFSNewApproach numberOfIslandsDFSNewApproach = new NumberOfIslandsDFSNewApproach();

  @Test
    public void checkNumIslands() {
        char[][] grid = {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        Assert.assertEquals( 1, numberOfIslandsDFSNewApproach.numIslands(grid));
    }

    @Test
    public void checkNumIslands2() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Assert.assertEquals(  3, numberOfIslandsDFSNewApproach.numIslands(grid));
    }

}