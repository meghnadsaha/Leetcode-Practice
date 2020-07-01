package com.interview.graph.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.interview.graph.bfs.TheMazeIIOptimized;


public class TheMazeIIOptimizedTest {

	@Test
	public void test() {
		TheMazeIIOptimized all = new TheMazeIIOptimized();
		//start coordinate (rowStart, colStart)
		int[] start  = {0, 4};
		//destination coordinate (rowDest, colDest)
		int[] dest	 = {3, 2};
		int[][] maze = { 
		{ 0, 0, 1 ,0 ,0 }, 
		{ 0, 0, 0 ,0 ,0 }, 
		{ 0, 0, 0 ,1 ,0 }, 
		{ 1, 1, 0 ,1 ,1 }, 
		{ 0, 0, 0 ,0 ,0 }, 

		};		

		Assert.assertEquals(-1, all.shortestDistance(maze, start, dest));

	}

}
