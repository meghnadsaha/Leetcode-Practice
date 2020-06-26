package com.interview.dynamic.programming;


import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubsequence {

	@Test
	public void test() {
		LongestPalindromicSubsequence_516 longestPalindromicSubsequence = new LongestPalindromicSubsequence_516();
		Assert.assertEquals(4, longestPalindromicSubsequence.longestPalindromeSubseq("bbbab"));
//		Assert.assertEquals(3, longestPalindromicSubsequence.longestPalindromeSubseq("aba"));
	}

}
