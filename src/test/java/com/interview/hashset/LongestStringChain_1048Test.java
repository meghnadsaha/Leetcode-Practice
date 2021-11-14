package com.interview.hashset;

import org.junit.Assert;
import org.junit.Test;

import com.interview.dynamic.programming.others.LongestStringChain_1048;

public class LongestStringChain_1048Test {

	@Test
	public void test() {
		LongestStringChain_1048 longestStringChain = new LongestStringChain_1048();
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };

		Assert.assertEquals(4, longestStringChain.longestStrChain(words));

	}

}
