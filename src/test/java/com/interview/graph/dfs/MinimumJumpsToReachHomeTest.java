package com.interview.graph.dfs;

import org.junit.Assert;
import org.junit.Test;

public class MinimumJumpsToReachHomeTest {

    MinimumJumpsToReachHome minimumJumpsToReachHome = new MinimumJumpsToReachHome();
    @Test
    public void minimumJumpsTest() {
        int[] forbidden = {14, 4, 18, 1, 15};
        int a = 3, b = 15, x = 9;

        Assert.assertEquals(3, minimumJumpsToReachHome.minimumJumps(forbidden, a, b, x));
    }

    @Test
    public void minimumJumpsTest2() {
        int[] forbidden1 = {8, 3, 16, 6, 12, 20};
        int a1 = 15, b1 = 13, x1 = 11;
        Assert.assertEquals(-1, minimumJumpsToReachHome.minimumJumps(forbidden1, a1, b1, x1));
    }

    @Test
    public void minimumJumpsTest3() {
        int[] forbidden2 = {1, 6, 2, 14, 5, 17, 4};
        int a2 = 16, b2 = 9, x2 = 7;
        Assert.assertEquals(2, minimumJumpsToReachHome.minimumJumps(forbidden2, a2, b2, x2));
    }

    @Test
    public void minimumJumpsTest4() {
        int[] forbidden = {162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98};
        int a = 29, b = 98, x = 80;
        Assert.assertEquals(121, minimumJumpsToReachHome.minimumJumps(forbidden, a, b, x));
    }


}
