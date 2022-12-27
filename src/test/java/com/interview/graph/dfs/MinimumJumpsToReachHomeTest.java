package com.interview.graph.dfs;

import org.junit.Assert;
import org.junit.Test;

public class MinimumJumpsToReachHomeTest {

    @Test
    public void minimumJumpsTest() {

//        int[] forbidden = {14, 4, 18, 1, 15};
//        int a = 3, b = 15, x = 9;
//        Assert.assertEquals(3, MinimumJumpsToReachHome.minimumJumps(forbidden, a, b, x));


        int[] forbidden1 = {8, 3, 16, 6, 12, 20};
        int a1 = 15, b1 = 13, x1 = 11;
        Assert.assertEquals(-1, MinimumJumpsToReachHome.minimumJumps(forbidden1, a1, b1, x1));


//        int[] forbidden2 = {1, 6, 2, 14, 5, 17, 4};
//        int a2 = 16, b2 = 9, x2 = 7;
//        Assert.assertEquals(2, MinimumJumpsToReachHome.minimumJumps(forbidden2, a2, b2, x2));

    }

}
