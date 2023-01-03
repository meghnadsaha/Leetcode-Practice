package com.interview.greedy.medium.bfs;


public class JumpGameII {
    //https://leetcode.com/problems/jump-game-ii/solutions/1192401/easy-solutions-w-explanation-optimizations-from-brute-force-to-dp-to-greedy-bfs/?orderBy=most_votes
    public int jump(int[] nums) {

        int n = nums.length, i = 0, maxReachable = 0, lastJumpedPos = 0, jumps = 0;
        while (lastJumpedPos < n - 1) {  // loop till last jump hasn't taken us till the end
            maxReachable = Math.max(maxReachable, i + nums[i]);  // furthest index reachable on the next level from current level
            if (i == lastJumpedPos) {              // current level has been iterated & maxReachable position on next level has been finalised
                lastJumpedPos = maxReachable;     // so just move to that maxReachable position
                jumps++;                          // and increment the level
                // NOTE: jump^ only gets updated after we iterate all possible jumps from previous level
                //       This ensures jumps will only store minimum jump required to reach lastJumpedPos
            }
            i++;
        }
        return jumps;
    }
}
