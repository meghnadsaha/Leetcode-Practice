package com.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AllPathsFromSourcetoTargetTest {

	@Test
	public void test() {
		AllPathsFromSourcetoTarget all = new AllPathsFromSourcetoTarget();
		int[][] graph = {{1,2}, {3}, {3}, {}} ;
		System.out.println((all.allPathsSourceTarget(graph)));
		//Assert.assertEquals(accountsExpectedOutput, acMergeTest.accountsMerge(accountsInput));
		
	}

}
