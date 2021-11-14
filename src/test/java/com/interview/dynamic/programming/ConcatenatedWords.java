package com.interview.dynamic.programming;

import java.util.*;

import com.interview.dynamic.programming.others.ConcatenatedWords_472;
import org.junit.Assert;
import org.junit.Test;

public class ConcatenatedWords {

	@Test
	public void test() {
		String[] actualListOfWords = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses",
				"rat","ratcatdogcat" };
		String[] expectedConcatenatedWords = { "catsdogcats", "dogcatsdog", "ratcatdogcat" };
		List<String> expectedConcatenatedListOfWords = Arrays.asList(expectedConcatenatedWords);

		ConcatenatedWords_472 concatenatedWords = new ConcatenatedWords_472();
		
		Assert.assertEquals(expectedConcatenatedListOfWords,
				concatenatedWords.findAllConcatenatedWordsInADict(actualListOfWords));

	}

}
