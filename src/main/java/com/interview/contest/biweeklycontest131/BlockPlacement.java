//package com.interview.contest.biweeklycontest131;
//
//
//import java.util.*;
//
//public class BlockPlacement {
//    public static boolean[] canPlaceBlock ( int[][] queries ) {
//        TreeMap<Integer, Integer> obstacles = new TreeMap<>();
//        List<Boolean> result = new ArrayList<>();
//
//        for (int[] query : queries) {
//            int type = query[0];
//            int x = query[1];
//            if (type == 1) {
//                obstacles.put(x , 1);
//            } else {
//                int sz = query[2];
//                // Find the obstacle at or to the left of x
//                Integer obstaclePos = obstacles.floorKey(x);
//                if (obstaclePos == null || obstaclePos < x - sz) {
//                    result.add(true);
//                } else {
//                    result.add(false);
//                }
//            }
//        }
//
//        return result.stream().mapToBoolean(Boolean::booleanValue).toArray();
//    }
//
//    public static void main ( String[] args ) {
//        int[][] queries1 = {{1 , 2} , {2 , 3 , 3} , {2 , 3 , 1} , {2 , 2 , 2}};
//        boolean[] result1 = canPlaceBlock(queries1);
//        // Output: [false, true, true]
//        System.out.println(Arrays.toString(result1));
//
//        int[][] queries2 = {{1 , 7} , {2 , 7 , 6} , {1 , 2} , {2 , 7 , 5} , {2 , 7 , 6}};
//        boolean[] result2 = canPlaceBlock(queries2);
//        // Output: [true, true, false]
//        System.out.println(Arrays.toString(result2));
//    }
//}
