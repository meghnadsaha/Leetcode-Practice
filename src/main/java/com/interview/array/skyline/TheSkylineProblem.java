package com.interview.array.skyline;

import java.util.*;

public class TheSkylineProblem {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyline = new ArrayList<>();
        List<int[]> criticalPoints = new ArrayList<>();

        // Generate critical points from the buildings
        for (int[] building : buildings) {
            // Add critical points for the start and end of the building
            criticalPoints.add(new int[]{building[0], -building[2]});
            criticalPoints.add(new int[]{building[1], building[2]});
        }

        // Sort the critical points by x-coordinate, breaking ties using the building height
        criticalPoints.sort(Comparator.comparingInt((int[] cp) -> cp[0]).thenComparingInt(cp -> cp[1]));

        // Use a priority queue to keep track of the current maximum height
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(0); // Add a default height of 0

        TreeMap<Integer, Integer> heightCountMap = new TreeMap<>();

        int prevHeight = 0;

        for (int[] cp : criticalPoints) {
            int x = cp[0];
            int height = cp[1];

            if (height < 0) {
                // Start of a building
                heightCountMap.put(-height, heightCountMap.getOrDefault(-height, 0) + 1);
            } else {
                // End of a building
                int count = heightCountMap.get(height);
                if (count == 1) {
                    heightCountMap.remove(height);
                } else {
                    heightCountMap.put(height, count - 1);
                }
            }
            if (heightCountMap.size()>0){
                int currHeight = heightCountMap.lastKey(); // Current maximum height

            if (currHeight != prevHeight) {
                skyline.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }
    }
        return skyline;
    }

    public static void main(String[] args) {
        int[][] buildings = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };

        List<List<Integer>> skyline = getSkyline(buildings);

        for (List<Integer> point : skyline) {
            System.out.println("[" + point.get(0) + ", " + point.get(1) + "]");
        }
    }
}
