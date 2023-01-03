package com.interview.graph.dfs;

import com.interview.graph.dfs.medium.CourseSchedule;
import org.junit.Assert;
import org.junit.Test;

public class CourseScheduleTest {

	@Test
	public void test() {
		CourseSchedule all = new CourseSchedule();
		int[][] prerequisites  = {{1,0}} ;
		int[][] prerequisites2  = {{1,0}, {0,1}} ;
		
		Assert.assertEquals(true, all.canFinish(2, prerequisites));
	//	Assert.assertEquals(false, all.canFinish(2, prerequisites2));

	}

}
