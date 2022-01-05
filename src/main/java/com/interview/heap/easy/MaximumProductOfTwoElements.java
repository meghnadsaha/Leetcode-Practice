package com.interview.heap.easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumProductOfTwoElements {
    public static int maxProduct(int[] nums) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer i : nums) {
            maxHeap.add(i);
        }
        return (maxHeap.poll() - 1) * (maxHeap.peek() - 1);
        /**
         * The poll() method in Java is used to retrieve or fetch and remove the first element of the Queue or the element present at the head of the Queue.
         * The peek() method only retrieved the element at the head but the poll() also removes the element along with the retrieval. It returns NULL if the queue is empty.
         *
         */

    }

    public static void main(String args[]) {
        maxProduct(new int[]{3, 4, 5, 2});
    }
}
