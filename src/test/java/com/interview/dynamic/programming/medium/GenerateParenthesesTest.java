package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class GenerateParenthesesTest {
    @Test
    public void testGenerateParenthesis0() {

        GenerateParentheses generateParentheses = new GenerateParentheses();

        List<String> expectedOutput = Arrays.asList("((()))","(()())","(())()","()(())","()()()");
        List<String> actualOutput = generateParentheses.generateParenthesis(3);

        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
