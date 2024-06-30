package com.interview.contest.weeklycontest.c_404;

public class MaxHeightOfTriangle {


    public static int maxHeightOfTriangle(int red, int blue) {
    int low = 0;
    int high = (int) Math.sqrt(2 * (red + blue)) + 1;

        while (low < high) {
        int mid = (low + high + 1) / 2;
        if (canFormTriangle(mid, red, blue)) {
            low = mid;
        } else {
            high = mid - 1;
        }
    }

        return low;
}

    private static boolean canFormTriangle(int h, int red, int blue) {
        int redNeeded = 0;
        int blueNeeded = 0;

        for (int i = 1; i <= h; i++) {
            if (i % 2 == 1) {
                redNeeded += i;
            } else {
                blueNeeded += i;
            }
        }

        if (redNeeded <= red && blueNeeded <= blue) {
            return true;
        }

        redNeeded = 0;
        blueNeeded = 0;

        for (int i = 1; i <= h; i++) {
            if (i % 2 == 1) {
                blueNeeded += i;
            } else {
                redNeeded += i;
            }
        }

        return redNeeded <= red && blueNeeded <= blue;
    }

    public static void main(String[] args) {
        int red1 = 2, blue1 = 4;
        System.out.println(maxHeightOfTriangle(red1, blue1));  // Output: 3

        int red2 = 2, blue2 = 1;
        System.out.println(maxHeightOfTriangle(red2, blue2));  // Output: 2

        int red3 = 1, blue3 = 1;
        System.out.println(maxHeightOfTriangle(red3, blue3));  // Output: 1

        int red4 = 10, blue4 = 1;
        System.out.println(maxHeightOfTriangle(red4, blue4));  // Output: 2
    }
}
