package com.interview.graph.bfs.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * @link2 : https://leetcode.com/problems/course-schedule/solutions/58524/java-dfs-and-bfs-solution/?orderBy=most_votes
 */

public class CourseScheduleUsingDFS {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        // create the array lists to represent the courses
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }
        // create the dependency graph
        for (int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // dfs visit each course
        for (int i = 0; i < numCourses; i++)
            if (!findCycleDfs(i, courses, visited)) {
                return false;
            }
        return true;
    }

    private static boolean findCycleDfs(int course, List<List<Integer>> courses, int[] visited) {
            visited[course] = 1; // mark it being visited
            List<Integer> eligibleCourses = courses.get(course); // get its children
            // dfs its children
            for (int i = 0; i < eligibleCourses.size(); i++) {
                int eligibleCourse = eligibleCourses.get(i).intValue();

                if (visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
                if (visited[eligibleCourse] == 0) { // not visited
                    if (!findCycleDfs(eligibleCourse, courses, visited)) return false;
                }

            }

            visited[course] = 2; // mark it done visiting
            return true;
    }

    public static void main(String args[]) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.print(canFinish(numCourses, prerequisites));
    }
};