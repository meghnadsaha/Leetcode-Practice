package com.interview.graph;

import com.interview.graph.others.OptimizeWaterDistribution;
import org.junit.Assert;
import org.junit.Test;


public class OptimizeWaterDistributionTest {

	@Test
	public void test() {
		OptimizeWaterDistribution all = new OptimizeWaterDistribution();
		int n = 3;
		int wells[] = { 1, 2, 2 };
		// pipes[i] = [house1, house2, cost]
		//represents the cost to connect house1 and house2 together using a pipe. 
		int[][] pipes = { { 1, 2, 1 }, { 2, 3, 1 } };

		Assert.assertEquals(3, all.minCostToSupplyWater(n, wells, pipes));

	}

}
