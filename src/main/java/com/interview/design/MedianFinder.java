package com.interview.design;

import java.util.*;

public class MedianFinder {

	Queue<Integer> smalls = new PriorityQueue<>(Collections.reverseOrder());
	Queue<Integer> bigs = new PriorityQueue<>();

	public MedianFinder() {
	}

	public void addNum(int num) {
		if (smalls.isEmpty()) {
			smalls.add(num);
		} else if (smalls.size() == bigs.size()) {
			if (num > bigs.peek()) {
				smalls.add(bigs.poll());
				bigs.add(num);
			} else {
				smalls.add(num);
			}
		} else {
			if (num < smalls.peek()) {
				bigs.add(smalls.poll());
				smalls.add(num);
			} else {
				bigs.add(num);
			}
		}
	}

	public double findMedian() {
		if (bigs.isEmpty() && smalls.isEmpty())
			return 0;
		if (smalls.isEmpty())
			return bigs.peek();
		if (bigs.isEmpty())
			return smalls.peek();
		if (smalls.size() == bigs.size())
			return (bigs.peek() + smalls.peek()) / 2.0;
		return smalls.peek();
	}

}
