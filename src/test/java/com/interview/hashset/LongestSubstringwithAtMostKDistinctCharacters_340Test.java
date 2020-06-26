package com.interview.hashset;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringwithAtMostKDistinctCharacters_340Test {
	@Test
	public void testDifferentCases() {
		LongestSubstringwithAtMostKDistinctCharacters_340 lKDistinctCharacters_340 = new LongestSubstringwithAtMostKDistinctCharacters_340();
		Assert.assertEquals(3, lKDistinctCharacters_340.lengthOfLongestSubstringKDistinct("eceba",2));
		Assert.assertEquals(2, lKDistinctCharacters_340.lengthOfLongestSubstringKDistinct("aa",1));

	}
}
