package com.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AccountsMergeTest {

	@Test
	public void test() {
		AccountsMerge acMergeTest = new AccountsMerge();

		List<List<String>> accountsInput = Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
				Arrays.asList("John", "johnnybravo@mail.com"),
				Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
				Arrays.asList("John", "mary@mail.com"));

		List<List<String>> accountsExpectedOutput = Arrays.asList(
				Arrays.asList("John", "johnnybravo@mail.com"),
				Arrays.asList("John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"),
				Arrays.asList("Mary", "mary@mail.com"));
		System.out.println((acMergeTest.accountsMerge(accountsInput)));
		//Assert.assertEquals(accountsExpectedOutput, acMergeTest.accountsMerge(accountsInput));
		
	}

}
