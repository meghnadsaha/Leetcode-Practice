package com.interview.bit.manipulation;

public class CountingBits {
	public int[] countBits(int nums) {
		int ar[] = new int[nums + 1];
		ar[0] = 0;
		if (nums == 0)
			return ar;
		ar[1] = 1;
		if (nums == 1)
			return ar;

		for (int i = 2; i <= nums; i++)
			ar[i] = i % 2 == 0 ? ar[i >> 1] : ar[i >> 1] + 1;

		return ar;
	}
}