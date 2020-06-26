package com.interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class WordBreakIITest {

	@Test
	public void test() {
		WordBreakII all = new WordBreakII();
		List<String> aList = Arrays.asList("cat", "cats", "and", "sand", "dog");
		String s = "catsanddog";
		 Set<String> wordDict = new HashSet<String>(); 
	        for (String x : aList) 
	        	wordDict.add(x); 
	  		

		System.out.println(all.wordBreak(s,(aList)));


		// Assert.assertEquals(Arrays.asList(output),all.(board, (words)) );

	}

}
