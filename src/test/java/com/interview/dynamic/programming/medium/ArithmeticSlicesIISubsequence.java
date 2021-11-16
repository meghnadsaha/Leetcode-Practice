package com.interview.dynamic.programming.medium;

import com.interview.dynamic.programming.others.ArithmeticSlicesIISubsequence_446;
import org.junit.*;

public class ArithmeticSlicesIISubsequence {

	@Test
	public void test() {
		ArithmeticSlicesIISubsequence_446 aIiSubsequence = new ArithmeticSlicesIISubsequence_446();
		int[] input = { 2, 4, 6, 8, 10 };

		Assert.assertEquals(7, aIiSubsequence.numberOfArithmeticSlices(input));
	}

}
