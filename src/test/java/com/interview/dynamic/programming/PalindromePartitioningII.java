package com.interview.dynamic.programming;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PalindromePartitioningII {

	@Test
	public void test() {
		PalindromePartitioningII_132 palindromePartitioningII_132 = new PalindromePartitioningII_132();
		int actual = palindromePartitioningII_132.minCut("aab");
		int expected = 1;
		
		Assert.assertEquals(expected, actual);
	}

}
