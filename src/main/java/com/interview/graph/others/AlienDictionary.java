package com.interview.graph.others;

import java.util.*;
	
public class AlienDictionary {

	public String alienOrder(String words[]) {
		int indegree[] = new int[26];
		Map<Character, Set<Character>> g = new HashMap<>();
		buildGraph(g, words, indegree);
		return bfs(g, indegree);
	}

	private String bfs(Map<Character, Set<Character>> graph, int[] indegree) {

		StringBuilder sb = new StringBuilder();
		int totalChar = graph.size();
		Queue<Character> q = new LinkedList<>();
		for (char c : graph.keySet()) {
			if (indegree[c - 'a'] == 0) {
				sb.append(c);
				q.offer(c);
			}
		}

		while (!q.isEmpty()) {
			char curr = q.poll();
			if (graph.get(curr) == null || graph.get(curr).size() == 0)
				continue;

			sb.append(curr);
			for (char in : graph.get(curr)) {
				indegree[in - 'a']--;
				if (indegree[in - 'a'] == 0) {
					q.offer(in);
				}
			}
		}
		return sb.length() == graph.size() ? sb.toString() : "";
	}

	private void buildGraph(Map<Character, Set<Character>> g, String words[], int indegree[]) {
		for (String word : words) {
			for (char c : word.toCharArray()) {
				g.putIfAbsent(c, new HashSet<Character>());
			}
		}

		for (int i = 1; i < words.length; i++) {
			String first = words[i - 1];
			String second = words[i];
			int len = Math.max(first.length(), second.length());

			for (int j = 0; j < len; j++) {
				if (first.charAt(j) != second.charAt(j)) {
					char out = first.charAt(j);
					char in = second.charAt(j);

					if (g.get(out).contains(in)) {
						g.get(out).add(in);
						indegree[in - 'a']++;
					}
					break;
				}
			}
		}
	}

}
