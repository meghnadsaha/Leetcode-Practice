package com.interview.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum ( int[] nums , int target ) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length - 3 ; i++) {
            // Skip duplicate elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1 ; j < nums.length - 2 ; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[left] + (long) nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i] , nums[j] , nums[left] , nums[right]));

                        // Skip duplicates for left and right pointers
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main ( String[] args ) {
        FourSum solution = new FourSum();
        int[] nums1 = {1 , 0 , -1 , 0 , -2 , 2};
        int target1 = 0;
        List<List<Integer>> result1 = solution.fourSum(nums1 , target1);
        System.out.println(result1);

        int[] nums2 = {1000000000 , 1000000000 , 1000000000 , 1000000000};
        int target2 = -294967296;
        List<List<Integer>> result2 = solution.fourSum(nums2 , target2);
        System.out.println(result2);
    }
}
