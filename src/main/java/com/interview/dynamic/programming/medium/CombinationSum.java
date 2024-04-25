package com.interview.dynamic.programming.medium;

import java.util.*;

public class CombinationSum {

    public static void printDP(List<List<Integer>>[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print("dp[" + i + "] = ");
            for (List<Integer> list : dp[i]) {
                System.out.print(list + " ");
            }
            System.out.println();
        }
    }

    public static void printList(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new List[target + 1];
        for (int i = 0; i <= target; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());

        for (int candidate : candidates) {
            for (int i = candidate; i <= target; i++) {
                for (List<Integer> list : dp[i - candidate]) {
                    System.out.println("i : "+i );
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(candidate);
                    printList(newList);

                    dp[i].add(newList);
                    printDP(dp);
                    System.out.println(" ====== ");
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(combinationSum(candidates1, target1)); // Output: [[2, 2, 3], [7]]

//        int[] candidates2 = {2, 3, 5};
//        int target2 = 8;
//        System.out.println(combinationSum(candidates2, target2)); // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
//
//        int[] candidates3 = {2};
//        int target3 = 1;
//        System.out.println(combinationSum(candidates3, target3)); // Output: []
    }
}
