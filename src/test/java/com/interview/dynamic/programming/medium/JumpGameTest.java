package com.interview.dynamic.programming.medium;

import org.junit.Assert;
import org.junit.Test;

public class JumpGameTest {


    @Test
    public void testCanJump() {

        int[] nums = {2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();

        boolean expectedOutput = true;
        boolean actualOutput = jumpGame.canJump(nums);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testCanJump2() {

        int[] nums = {3,2,1,0,4};
        JumpGame jumpGame = new JumpGame();

        boolean expectedOutput = false;
        boolean actualOutput = jumpGame.canJump(nums);

        Assert.assertEquals(expectedOutput, actualOutput);
    }
}
