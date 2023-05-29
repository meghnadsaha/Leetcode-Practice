package com.interview.array.skyline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * To solve the problem of finding the skyline given the locations and heights of buildings,
 * you can use the Divide and Conquer approach with a modified form of the Merge Sort algorithm.
 *
 */

public class SkylineUsingDivideAndConquer {

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<>();
        }

        return mergeSort(buildings, 0, buildings.length - 1);
    }

    private static List<List<Integer>> mergeSort(int[][] buildings, int left, int right) {
        if (left == right) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(buildings[left][0], buildings[left][2]));
            result.add(Arrays.asList(buildings[left][1], 0));
            return result;
        }

        int mid = left + (right - left) / 2;
        // Divide the buildings into two halves and recursively find the skylines
        List<List<Integer>> leftSkyline = mergeSort(buildings, left, mid);
        // [2,10][3,15],[7,10],[9,0]
        List<List<Integer>> rightSkyline = mergeSort(buildings, mid + 1, right);
        // [5,12][12,0]
        // Merge the skylines
        return merge(leftSkyline, rightSkyline);
    }

    private static List<List<Integer>> merge(List<List<Integer>> leftSkyline, List<List<Integer>> rightSkyline) {
        List<List<Integer>> mergedSkyline = new ArrayList<>();
        int leftHeight = 0;
        int rightHeight = 0;
        int i = 0;
        int j = 0;
        /**
         * i and j are integer variables initialized to 0. These variables are used as indices
         * to iterate through the leftSkyline and rightSkyline lists while merging the skylines in the mergeSkylines method.
         *
         * The variable i is used to track the current index in the leftSkyline list, and j is
         * used to track the current index in the rightSkyline list. By incrementing these indices
         * appropriately, the code iterates through the key points of both skylines and merges them in the resulting skyline.
         */


        while (i < leftSkyline.size() && j < rightSkyline.size()) {
            List<Integer> leftPoint = leftSkyline.get(i);
            List<Integer> rightPoint = rightSkyline.get(j);

            int x;
            int height;

            if (leftPoint.get(0) < rightPoint.get(0)) {
                x = leftPoint.get(0);
                leftHeight = leftPoint.get(1);
                height = Math.max(leftHeight, rightHeight);
                i++;
            } else if (leftPoint.get(0) > rightPoint.get(0)) {
                x = rightPoint.get(0);
                rightHeight = rightPoint.get(1);
                height = Math.max(leftHeight, rightHeight);
                j++;
            } else {
                x = leftPoint.get(0);
                leftHeight = leftPoint.get(1);
                rightHeight = rightPoint.get(1);
                height = Math.max(leftHeight, rightHeight);
                i++;
                j++;
            }

            if (mergedSkyline.isEmpty() || height != mergedSkyline.get(mergedSkyline.size() - 1).get(1)) {
                mergedSkyline.add(Arrays.asList(x, height));
            }
        }

        while (i < leftSkyline.size()) {
            mergedSkyline.add(leftSkyline.get(i));
            i++;
        }

        while (j < rightSkyline.size()) {
            mergedSkyline.add(rightSkyline.get(j));
            j++;
        }

        return mergedSkyline;
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
