package com.interview.hashset;

import org.junit.Assert;
import org.junit.Test;

public class LongestDuplicateSubstringTest {

	@Test
	public void testDifferentCases() {
		LongestDuplicateSubstring_1044 loDuplicateSubstring = new LongestDuplicateSubstring_1044();
		Assert.assertEquals("ana", loDuplicateSubstring.longestDupSubstring("banana"));
		Assert.assertEquals("aabaaba", loDuplicateSubstring.longestDupSubstring("aabaabaaba"));
		Assert.assertEquals("aaaaaaaaaa", loDuplicateSubstring.longestDupSubstring("aaaaaaaaaaa"));
		Assert.assertEquals("acadabrabra",
				loDuplicateSubstring.longestDupSubstring("abacadabrabracabracadabrabrabracad"));

	}
}
