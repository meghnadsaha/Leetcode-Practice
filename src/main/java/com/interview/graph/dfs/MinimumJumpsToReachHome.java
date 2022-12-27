package com.interview.graph.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumJumpsToReachHome {

    private static Map<String/*idx + direction*/, Integer> cache;

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        cache = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> forbit = new HashSet<>();
        int maxLimit = 2000 + 2 * b;
        for (int num : forbidden) {
            forbit.add(num);
            maxLimit = Math.max(maxLimit, num + 2 * b);
        }
        int val = helper(0, x, a, b, forbit, visited, 0, maxLimit);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    private static int helper(int idx, int x, int a, int b, Set<Integer> forbit, Set<Integer> visited, int dir, int maxLimit) {
        if (cache.containsKey(idx + "," + dir)) {
            return cache.get(idx + "," + dir);
        }
        if (idx == x) return 0;
        if (idx < 0 || idx > maxLimit) return Integer.MAX_VALUE;
        visited.add(idx);
        int min = Integer.MAX_VALUE;
        //try jump forward
        if (idx + a < maxLimit && !forbit.contains(idx + a) && !visited.contains(idx + a)) {
            int step = helper(idx + a, x, a, b, forbit, visited, 0, maxLimit);
            if (step != Integer.MAX_VALUE) {
                min = Math.min(min, step + 1);
            }
        }
        //try jump back
        if (idx - b >= 0 && !forbit.contains(idx - b) && !visited.contains(idx - b) && dir != 1) {
            int step = helper(idx - b, x, a, b, forbit, visited, 1, maxLimit);
            if (step != Integer.MAX_VALUE) {
                min = Math.min(min, step + 1);
            }
        }
        visited.remove(idx);
        cache.put(idx + "," + dir, min);
        return min;
    }

    public static void main(String args[]) {


        int[] forbidden = {14, 4, 18, 1, 15};
        int a = 3, b = 15, x = 9;
        int minimumJumps = minimumJumps(forbidden, a, b, x);
        System.out.print(minimumJumps +" jumps forward will get the bug home.");

        int[] forbidden1 = {8,3,16,6,12,20};
        int a1 = 15, b1 = 13, x1 = 11;
        int minimumJumps1 = minimumJumps(forbidden1, a1, b1, x1);
        System.out.print("\n"+minimumJumps1+ " jumps forward will get the bug home.");


        int[] forbidden2 = {1,6,2,14,5,17,4};
        int a2 = 16, b2 = 9, x2 = 7;
        int minimumJumps2 = minimumJumps(forbidden2, a2, b2, x2);
        System.out.print("\n"+minimumJumps2+ " jumps forward will get the bug home.");

    }
}