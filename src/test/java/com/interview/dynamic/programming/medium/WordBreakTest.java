package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreakTest {

    @Test
    public void testWordBreak1() {

        String s = "leetcode";
        Set<String> wordDict = new HashSet<>(Arrays.asList("leet", "code"));

        WordBreak wordBreak = new WordBreak();

        boolean expectedOutput = true;
        boolean actualOutput = wordBreak.wordBreak(s,wordDict);

        Assert.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testWordBreak2() {

        String s = "applepenapple";
        Set<String> wordDict = new HashSet<>(Arrays.asList("apple","pen"));

        WordBreak wordBreak = new WordBreak();

        boolean expectedOutput = true;
        boolean actualOutput = wordBreak.wordBreak(s,wordDict);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testWordBreak3() {

        String s = "catsandog";
        Set<String> wordDict = new HashSet<>(Arrays.asList("cats","dog","sand","and","cat"));

        WordBreak wordBreak = new WordBreak();

        boolean expectedOutput = false;
        boolean actualOutput = wordBreak.wordBreak(s,wordDict);

        Assert.assertEquals(expectedOutput, actualOutput);
    }



}
