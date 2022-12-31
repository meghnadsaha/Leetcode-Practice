package com.interview.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumJumpsToReachHomeUsingBFS {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int n = forbidden.length;
        //2D boolean to keep track of forward and backward visits
        boolean[][] visited = new boolean[6000][2];
        if (x == 0) return 0;
        for (int i = 0; i < n; i++) {
            //for forbidden numbers we can not go to them
            //either forward or backward moment
            visited[forbidden[i]][0] = true;
            visited[forbidden[i]][1] = true;
        }
        int ans = 0;
        //queue to perform bfs
        Queue<int[]> q = new LinkedList();
        //array as input to keep track of both backward andd forward moment
        q.add(new int[]{0, 0});
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                int[] pos = q.poll();
                //not processing already visited numbers
                if (visited[pos[0]][pos[1]]) continue;
                visited[pos[0]][pos[1]] = true;
                //if home found we return ans
                if (pos[0] == x) return ans;
                //6000 is the maximum possible value for forward moment
                if (pos[0] + a < 6000) {
                    //forward moment shown marked by 0
                    q.add(new int[]{pos[0] + a, 0});
                }
                //to restrict double backward moment we mark backward
                //moment by adding 1
                if (pos[0] - b >= 0 && pos[1] != 1) {
                    q.add(new int[]{pos[0] - b, 1});
                }
            }
            ans++;
        }
        return -1;
    }
}