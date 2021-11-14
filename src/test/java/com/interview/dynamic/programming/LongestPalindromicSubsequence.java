package com.interview.dynamic.programming;


import com.interview.dynamic.programming.others.LongestPalindromicSubsequence_516;
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
