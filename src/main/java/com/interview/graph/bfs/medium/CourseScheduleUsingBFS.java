package com.interview.graph.bfs.medium;

import java.util.ArrayList;

public class CourseScheduleUsingBFS {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        ArrayList<Integer> bfs = new ArrayList();

        for (int i = 0; i < numCourses; ++i) graph[i] = new ArrayList<Integer>();

        for (int[] e : prerequisites) {
            graph[e[1]].add(e[0]);
            inDegree[e[0]]++;
        }
        for (int i = 0; i < numCourses; ++i)
            if (inDegree[i] == 0)
                bfs.add(i);

        for (int i = 0; i < bfs.size(); ++i)
            for (int j : graph[bfs.get(i)])
                if (--inDegree[j] == 0) bfs.add(j);
        return bfs.size() == numCourses;
    }

}