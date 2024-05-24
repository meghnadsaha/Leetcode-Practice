package com.interview.two.pointer.intersection;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                //This part of the condition checks if the last element added to the intersection list
                // is not equal to the current element (nums1[i]).
                // If it's not equal, it means the current element is different from the last one added,
                // so it is unique and can be added.
                if (intersection.isEmpty() || intersection.get(intersection.size() - 1) != nums1[i]) {
                    intersection.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        // Convert List to array
        int[] result = new int[intersection.size()];
        for (int k = 0 ; k < intersection.size() ; k++) {
            result[k] = intersection.get(k);
        }

        return result;
    }
}
