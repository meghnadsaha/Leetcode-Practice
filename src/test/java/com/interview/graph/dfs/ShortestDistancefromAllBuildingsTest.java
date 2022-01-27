package com.interview.graph.dfs;

import org.junit.Assert;
import org.junit.Test;

import com.interview.graph.others.ShortestDistancefromAllBuildings;

public class ShortestDistancefromAllBuildingsTest {

	@Test
	public void test() {
		ShortestDistancefromAllBuildings all = new ShortestDistancefromAllBuildings();
		int[][] prerequisites = { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, };
		int[][] prerequisites2 = { { 1, 0, 2, 0, 1 }, { 2, 0, 0, 2, 0 }, { 0, 2, 1, 0, 2 } };
		Assert.assertEquals(7, all.shortestDistance(prerequisites));
		Assert.assertEquals(-1, all.shortestDistance(prerequisites2));

	}

}
