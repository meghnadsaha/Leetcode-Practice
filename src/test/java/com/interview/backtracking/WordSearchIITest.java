package com.interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WordSearchIITest {

	@Test
	public void test() {
		WordSearchII all = new WordSearchII();
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = {"oath","pea","eat","rain"};
		String[] output = {"oath","eat"};
		
		

		 Assert.assertEquals(Arrays.asList(output),all.findWords(board, (words)) );

	}

}
