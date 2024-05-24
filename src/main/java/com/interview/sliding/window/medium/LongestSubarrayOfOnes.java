package com.interview.sliding.window.medium;

public class LongestSubarrayOfOnes {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLen = 0;

        while (right < nums.length) {
            // Expand the window by including nums[right]
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Print the current window with pointers
            System.out.print("Window: [");
            for (int i = left; i <= right; i++) {
                System.out.print(nums[i] + (i == right ? "" : ", "));
            }
            System.out.println("] (left: " + left + ", right: " + right + ")");

            // While there are more than one zero in the window, shrink the window from the left
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum length (right - left is the window size excluding the current zero)
            maxLen = Math.max(maxLen, right - left);

            // Move the right boundary of the window
            right++;
        }

        // Return the maximum length
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayOfOnes solution = new LongestSubarrayOfOnes();
        int[] nums1 = {1, 1, 0, 1};
        int[] nums2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};

        System.out.println("Output for nums1: " + solution.longestSubarray(nums1));  // Output: 3
        System.out.println("Output for nums2: " + solution.longestSubarray(nums2));  // Output: 5
    }
}
