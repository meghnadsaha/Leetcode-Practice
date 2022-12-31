package com.interview.graph.dfs.medium;


public class MinimumJumpsToReachHome {

    int target;
    int forward;
    int backward;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        target = x;
        forward = a;
        backward = b;
        // constraints -> 0 <= a, b, x <= 2000, hence we only need to process x indices 0 - 6000
        int[] DP = new int[1999];
        // mark all forbidden indices with -1
        for (int index : forbidden) DP[index] = -1;
        // recursive processing
        return getMinJumps(0, false, DP);
    }

    int getMinJumps(int index, boolean wasLastJumpBackward, int[] DP) {
        // exclusion case -> cannot jump to negative indices
        if (index < 0)
            return -1;
        // beyond this we will need more than 1 backward move to reach index between 0 to 2000
        if (index >= DP.length)
            return -1;
        // terminate and return not possible if we are going in cycles
        if (DP[index] == -2)
            return -1;
        // base case -> we have reached target
        if (index == target)
            return 0;
        // return memoized result
        if (DP[index] != 0)
            return DP[index];

        // process if not memoized
        DP[index] = -2; // mark (-2) as being processed to avoid cycles
        if (wasLastJumpBackward) {
            // cannot perform 2 consequitive backward jumps
            int moveForward = getMinJumps(index + forward, false, DP);

            if (moveForward == -1) {
                DP[index] = -1;
            } else {
                DP[index] = 1 + moveForward;
            }
        } else {
            // get minimum of forward and backward jump paths
            int moveBackward = getMinJumps(index - backward, true, DP);
            int moveForward = getMinJumps(index + forward, false, DP);
            System.out.println("moveBackward :"+moveBackward+ "  moveForward :"+moveForward);
            if (moveBackward == -1 && moveForward == -1) {
                DP[index] = -1;
            }
            else if (moveBackward == -1 || moveForward == -1) {
                DP[index] = 1 + Math.max(moveForward, moveBackward);
            } else {
                DP[index] = 1 + Math.min(moveForward, moveBackward);
            }
        }
        return DP[index];
    }
}