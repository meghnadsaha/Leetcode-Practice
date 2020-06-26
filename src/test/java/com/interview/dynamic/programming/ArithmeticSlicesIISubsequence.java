package com.interview.dynamic.programming;

import static org.junit.Assert.*;

import org.junit.*;

public class ArithmeticSlicesIISubsequence {

	@Test
	public void test() {
		ArithmeticSlicesIISubsequence_446 aIiSubsequence = new ArithmeticSlicesIISubsequence_446();
		int[] input = { 2, 4, 6, 8, 10 };

		Assert.assertEquals(7, aIiSubsequence.numberOfArithmeticSlices(input));
	}

}
