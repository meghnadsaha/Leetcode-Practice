package com.interview.hashset;

import org.junit.Assert;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {
	@Test
	public void testDifferentCases() {
		LongestSubstringWithoutRepeatingCharacters_3 lSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters_3();
		Assert.assertEquals(3, lSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
		Assert.assertEquals(1, lSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
		Assert.assertEquals(3, lSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
		
	}
}
