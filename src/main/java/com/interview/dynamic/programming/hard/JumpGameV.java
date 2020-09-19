package com.interview.dynamic.programming.hard;

public class JumpGameV {
    private static int dfs(int[] A, int i, int d, int[] dp) {
        if (dp[i] != 0) return dp[i];

        int res = 0, L = Math.max(0, i - d), R = Math.min(A.length - 1, i + d);

        for (int j = i - 1; j >= L && A[i] > A[j]; j--)
            res = Math.max(res, dfs(A, j, d, dp));

        for (int j = i + 1; j <= R && A[i] > A[j]; j++)
            res = Math.max(res, dfs(A, j, d, dp));

        return dp[i] = 1 + res;
    }

    public static int maxJumps(int[] arr, int d) {
        int n = arr.length, res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            res = Math.max(res, dfs(arr, i, d, dp));
        return res;
    }


    // 3 ms. 100%
    public static int maxJumps2(int[] arr, int d) {
        int n = arr.length, res = 0, top = 0;
        int[] dp = new int[n], stack = new int[n];
        for (int i = 0; i <= n; i++) {

            
            while (top > 0 && (i == n || arr[stack[top - 1]] < arr[i])) {
                int r = top - 1, l = r - 1;
                while (l >= 0 && arr[stack[l]] == arr[stack[r]]) l--;
                for (int j = l + 1; j <= r; j++) {
                    if (l >= 0 && stack[j] - stack[l] <= d)
                        dp[stack[l]] = Math.max(dp[stack[l]], 1 + dp[stack[j]]);
                    if (i < n && i - stack[j] <= d)
                        dp[i] = Math.max(dp[i], 1 + dp[stack[j]]);
                }
                top -= r - l;

            }
            stack[top++] = i;
        }
        for (int i = 0; i < n; i++)
            res = Math.max(res, dp[i]);
        return res + 1;
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        int d1 = 2;
        int[] arr5 = {7, 6, 5, 4, 3, 2, 1};
        int d5 = 1;
        int[] arr3 = {7, 1};
        int d3 = 1;
        int[] arr2 = {3, 3, 3, 3, 3};
        int d2 = 3;
        int[] arr4 = {66};
        int d4 = 1;


        System.out.println(maxJumps2(arr5, d5));
    }
}
