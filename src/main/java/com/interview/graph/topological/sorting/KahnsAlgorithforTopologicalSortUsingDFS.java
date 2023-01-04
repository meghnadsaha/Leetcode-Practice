package com.interview.graph.topological.sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @link :https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/
 * @link :https://www.scaler.com/topics/data-structures/topological-sort-algorithm/
 * @207CourseSchedule :https://leetcode.com/problems/course-schedule/solutions/1478383/cycle-detection-in-directed-graph-dfs-bfs-java/?orderBy=most_votes&languageTags=java&topicTags=breadth-first-search
 * <p>
 * @Time Complexity:O(V+E),where V=no.of nodes and E=no.of edges.This is a simple BFS algorithm.
 * <p>
 * @Space Complexity:O(N)+O(N)~O(2N),O(N)for the indegree array,and O(N)for the queue data structure
 * used in BFS(where N=no.of nodes).
 */

public class KahnsAlgorithforTopologicalSortUsingDFS {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        ;
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = KahnsAlgorithforTopologicalSortUsingDFS.topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}


/**
 * Output:4 5 0 2 3 1
 */