package com.interview.heap.easy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSubsequence {
    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        // [index, number]
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < n; i++) {
            heap.add(new int[]{i, nums[i]});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // sort by index
        List<int[]> list = new ArrayList<>(heap);
        list.sort(Comparator.comparingInt(a -> a[0]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[1];
        }

        return result;
    }


    public static void main(String args[]) {
        maxSubsequence(new int[]{2,1,3,3},2);
    }
}