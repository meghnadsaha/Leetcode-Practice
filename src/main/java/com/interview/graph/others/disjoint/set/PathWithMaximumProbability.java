package com.interview.graph.others.disjoint.set;

import java.util.*;

public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0], b = edges[i][1];
            g.computeIfAbsent(a, l -> new ArrayList<>()).add(new int[]{b, i});
            g.computeIfAbsent(b, l -> new ArrayList<>()).add(new int[]{a, i});
        }
        double[] p = new double[n];
        p[start] = 1d;
        Queue<Integer> q = new LinkedList<>(Arrays.asList(start));
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] a : g.getOrDefault(cur, Collections.emptyList())) {
                int neighbor = a[0], index = a[1];
                /**
                 * So, let's imagine an edge v-t and the probability connecting them to be 1. We have visited vand based on probability p[v],
                 * we updated p[t] also to the same value as p[v] as the edge connecting them has a prob of 1. Now, when we add t to the queue,
                 * we won't revisit the already visited neighbor v as p[t] * 1 is not > p[v].
                 *
                 * The only exception to the above scenario is when we have another vertex u in the same level(depth) as v with a p[u] > p[v]
                 * and probability of edge u-t is 1. Then, we will revisit v from t, because in this scenario, p[t] * 1 > p[v]
                 * as p[t] is updated by u vertex.
                 */

                if (p[cur] * succProb[index] > p[neighbor]) {
                    p[neighbor] = p[cur] * succProb[index];
                    q.offer(neighbor);
                }
            }
        }
        return p[end];
    }
}