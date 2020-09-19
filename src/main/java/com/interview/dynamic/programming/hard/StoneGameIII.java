package com.interview.dynamic.programming.hard;

public class StoneGameIII {

    public static boolean canReach(int[] arr, int start) {
        return canReach2(arr, start, new boolean[arr.length]);
    }

    private static boolean canReach2(int[] arr, int index, boolean[] visited) {
        if (index < 0 || index >= arr.length)
            return false;

        if (visited[index])
            return false;

        if (arr[index] == 0)
            return true;

        visited[index] = true;

        if (canReach2(arr, index + arr[index], visited)) return true;

        if (canReach2(arr, index - arr[index], visited)) return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
    }

}
