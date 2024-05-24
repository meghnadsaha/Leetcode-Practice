package com.interview.two.pointer.sortedarray;

import java.util.Arrays;

import java.util.logging.*;

public class FindTheDistanceValue {
    private static final Logger logger = Logger.getLogger(FindTheDistanceValue.class.getName());

    public static int findTheDistanceValue ( int[] arr1 , int[] arr2 , int d ) {
        Arrays.sort(arr2);
        int count = 0;

        for (int num : arr1) {
            if (!isWithinDistance(arr2 , num , d)) {
                count++;
            }
        }

        System.out.println("Count: " + count);
        return count;
    }

    private static boolean isWithinDistance ( int[] arr2 , int target , int d ) {
        System.out.println("Checking target: " + target + " " + Arrays.toString(arr2));
        int left = 0, right = arr2.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("left :" + left + " right :" + right + " mid :" + mid + " " + Arrays.toString(Arrays.copyOfRange(arr2 , left , mid+1)) + " and its value :" + arr2[mid]);
            System.out.println("arr2[" + mid + "] :" + arr2[mid] + " <= target :" + target + " " + " d: " + d);
            if (Math.abs(arr2[mid] - target) <= d) {
                System.out.println("Found within distance: " + arr2[mid]);
                return true;
            } else if (arr2[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            System.out.println("left :" + left + " right: " + right);
            System.out.println("\n");
        }

        System.out.println("Not found within distance");
        return false;
    }

    public static void main ( String[] args ) {


        int[] arr1 = {4 , 5 , 8};
        int[] arr2 = {10 , 9 , 1 , 8};
        int d = 2;
        System.out.println(findTheDistanceValue(arr1 , arr2 , d)); // Output: 2
    }
}
