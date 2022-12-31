package com.interview.greedy.medium.bfs;

import org.junit.Assert;
import org.junit.Test;

public class JumpGameIITest {
    @Test
    public void testMaxDepth() {

        JumpGameII jumpGameII = new JumpGameII();
        int actualOutput = jumpGameII.jump(new int[]{2, 3, 1, 1, 4});
        Assert.assertEquals(2, actualOutput);
    }

    @Test
    public void testMaxDepth2() {

        JumpGameII jumpGameII = new JumpGameII();
        int actualOutput = jumpGameII.jump(new int[]{2, 3, 0, 1, 4});
        Assert.assertEquals(2, actualOutput);
    }


}