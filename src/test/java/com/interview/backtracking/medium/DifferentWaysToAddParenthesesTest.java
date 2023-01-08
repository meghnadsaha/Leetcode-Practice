package com.interview.backtracking.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DifferentWaysToAddParenthesesTest {

    DifferentWaysToAddParentheses object = new DifferentWaysToAddParentheses();

    @Test
    public void diffWaysToCompute() {
        String expression = "2-1-1";
        List<Integer> expecteds = Arrays.asList(2, 0);
        Assert.assertEquals(expecteds, object.diffWaysToCompute(expression));
    }

    @Test
    public void diffWaysToComputeCaseTwo() {
        String expression = "2*3-4*5";
        List<Integer> expecteds = Arrays.asList(-34, -14, -10, -10, 10);
       // Assert.assertEquals(expecteds, object.diffWaysToCompute(expression));
    }

}