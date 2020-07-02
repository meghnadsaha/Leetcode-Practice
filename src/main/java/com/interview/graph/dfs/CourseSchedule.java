package com.interview.graph.dfs;
	
import java.util.*;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {

		Map<Integer, Set<Integer>> map = new HashMap<>();
		int[] pre = new int[numCourses];
		Set<Integer> set = new HashSet<>();
		for (int[] i : prerequisites) {
			pre[i[0]]++;
			map.putIfAbsent(i[1], new HashSet<>());
			map.get(i[1]).add(i[0]);
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < pre.length; i++) {
			if (pre[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			
			int cur = queue.poll();
			set.add(cur);
			if (map.get(cur) != null) {
				for (int i : map.get(cur)) {
					pre[i]--;
					if (pre[i] == 0) {
						queue.offer(i);
					}
				}
			}
		}
        return set.size() == numCourses;

	}
}
