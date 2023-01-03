package com.interview.graph.bfs;

import com.interview.graph.bfs.medium.CourseScheduleUsingDFS;
import org.junit.Assert;
import org.junit.Test;

public class CourseScheduleUsingDFSTest {


    CourseScheduleUsingDFS courseObj = new CourseScheduleUsingDFS();

    @Test
    public void canFinishCaseTwo() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        Assert.assertTrue(courseObj.canFinish(numCourses, prerequisites));
    }


    @Test
    public void canFinishCase35() {
        int numCourses = 7;
        int[][] prerequisites = {{1, 0},
                {0, 3}, {0, 2}, {3, 2}, {2, 5}, {4, 5}, {5, 6}, {2, 4}};
        Assert.assertTrue(courseObj.canFinish(numCourses, prerequisites));
    }


    }
