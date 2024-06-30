package com.interview.contest.weeklycontest.c_404;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumTreeDiameter {

//https://leetcode.com/contest/weekly-contest-404/problems/find-minimum-diameter-after-merging-two-trees/description/

    public int minimumDiameterAfterMerge ( int[][] edges1 , int[][] edges2 ) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<Integer>[] tree1 = buildTree(edges1 , n);
        List<Integer>[] tree2 = buildTree(edges2 , m);

        int[] tree1DiameterInfo = findDiameterAndCenter(tree1 , n);
        int[] tree2DiameterInfo = findDiameterAndCenter(tree2 , m);

        int diameter1 = tree1DiameterInfo[0];
        int center1 = tree1DiameterInfo[1];

        int diameter2 = tree2DiameterInfo[0];
        int center2 = tree2DiameterInfo[1];

        // Calculate distance between centers
        int distanceBetweenCenters = bfsForDistance(tree1 , n , center1 , tree2 , m , center2);

        // Calculate the resulting diameter
        int resultDiameter = Math.max(diameter1 , Math.max(diameter2 , distanceBetweenCenters + 1));

        return resultDiameter;
    }

    // Helper function to build adjacency list representation of the tree
    private List<Integer>[] buildTree ( int[][] edges , int n ) {
        List<Integer>[] tree = new List[n];
        for (int i = 0 ; i < n ; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            tree[u].add(v);
            tree[v].add(u);
        }
        return tree;
    }

    // Helper function to find the diameter and center of a tree using BFS
    private int[] findDiameterAndCenter ( List<Integer>[] tree , int n ) {
        int[] result = new int[2];
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from node 0 (can be any node since tree is connected)
        queue.offer(0);
        visited[0] = true;

        int lastVisitedNode = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size ; i++) {
                int node = queue.poll();
                lastVisitedNode = node;
                for (int neighbor : tree[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        // Perform BFS again from the last visited node to find the farthest node and its distance
        queue.clear();
        queue.offer(lastVisitedNode);
        visited = new boolean[n];
        visited[lastVisitedNode] = true;
        int[] distance = new int[n];
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : tree[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    distance[neighbor] = distance[node] + 1;
                }
            }
        }

        // Find the node with the maximum distance from lastVisitedNode (diameter endpoints)
        int maxDistance = 0;
        int farthestNode = lastVisitedNode;
        for (int i = 0 ; i < n ; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                farthestNode = i;
            }
        }

        // Return diameter and center
        result[0] = maxDistance;
        result[1] = farthestNode;
        return result;
    }

    // Helper function to find shortest path distance between two centers using BFS
    private int bfsForDistance ( List<Integer>[] tree1 , int n , int center1 ,
                                 List<Integer>[] tree2 , int m , int center2 ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{center1 , center2});
        boolean[][] visited = new boolean[n][m];
        visited[center1][center2] = true;
        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size ; i++) {
                int[] nodePair = queue.poll();
                int node1 = nodePair[0];
                int node2 = nodePair[1];

                // Check all neighbors in tree1
                for (int neighbor1 : tree1[node1]) {
                    // Check all neighbors in tree2
                    for (int neighbor2 : tree2[node2]) {
                        if (!visited[neighbor1][neighbor2]) {
                            visited[neighbor1][neighbor2] = true;
                            queue.offer(new int[]{neighbor1 , neighbor2});
                        }
                    }
                }
            }
            distance++;
        }
        return distance - 1; // Subtract 1 to get the number of edges, not nodes
    }

    @Test
    public void testMinimumDiameterAfterMerge_Basic () {
        MinimumTreeDiameter solution = new MinimumTreeDiameter();

        // Example 1
        int[][] edges1 = {{0 , 1} , {0 , 2} , {0 , 3}};
        int[][] edges2 = {{0 , 1}};
        Assert.assertEquals(3 , solution.minimumDiameterAfterMerge(edges1 , edges2));

        // Example 2
        int[][] edges3 = {{0 , 1} , {0 , 2} , {0 , 3} , {2 , 4} , {2 , 5} , {3 , 6} , {2 , 7}};
        int[][] edges4 = {{0 , 1} , {0 , 2} , {0 , 3} , {2 , 4} , {2 , 5} , {3 , 6} , {2 , 7}};
        Assert.assertEquals(5 , solution.minimumDiameterAfterMerge(edges3 , edges4));


        int[][] edges5 = {{0, 1}};
        int[][] edges6 = {{0, 1}};

        Assert.assertEquals(3 , solution.minimumDiameterAfterMerge(edges5 , edges6));
    }

}
